package com.itxiaodu.credit.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.itxiaodu.credit.api.MysqlService;
import com.itxiaodu.credit.config.PayConfig;
import com.itxiaodu.credit.entity.vo.CreditOrderProjectVO;
import com.itxiaodu.credit.entity.vo.CreditOrderVO;
import com.itxiaodu.credit.entity.vo.MemberLoginvo;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class PayController {
    @Autowired
    private MysqlService mysqlService;

    @Autowired
    private PayConfig payConfig;

    public Logger logger = LoggerFactory.getLogger(PayController.class);

    @RequestMapping("/notify")
    public void notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, payConfig.getAlipayPublicKey(), payConfig.getCharset(), payConfig.getSignType()); //调用SDK验证签名

        if (signVerified) {//验证成功
            String orderNum = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String payOrderNum = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            logger.info("trade_status: " + trade_status);
        } else {//验证失败
            logger.info("验证失败");
        }
    }

    @ResponseBody
    @RequestMapping("/return")
    public String returnUrl(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException, AlipayApiException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, payConfig.getAlipayPublicKey(), payConfig.getCharset(), payConfig.getSignType()); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String orderNum = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String payOrderNum = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String orderAmount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            String br = "trade_no:" + orderNum + "<br/>out_trade_no:" + payOrderNum + "<br/>total_amount:" + orderAmount;
//            logger.info("orderAmount: " + orderAmount);
            CreditOrderVO creditOrderVO = (CreditOrderVO) session.getAttribute("CreditOrderVO");
            creditOrderVO.setPayOrderNum(payOrderNum);
            ResultType<String> resultType = mysqlService.saveCreditOrderVORemote(creditOrderVO);
            return br;
        } else {
            return "验证失败";
        }
    }

    @ResponseBody
    @RequestMapping("/generate/order")
    public String getGenerateOrder(HttpSession session, CreditOrderVO creditOrderVO) throws AlipayApiException {
        CreditOrderProjectVO creditOrderProjectVO = (CreditOrderProjectVO) session.getAttribute(CreditConstant.CONST_CREDIT_ORDER_PROJECT_DATA);
        if (creditOrderProjectVO != null) {
            creditOrderVO.setCreditOrderProjectVO(creditOrderProjectVO);
            Date date = new Date();
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
            String user = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            String userTemp = String.valueOf(((MemberLoginvo) session.getAttribute(CreditConstant.CONST_LOGIN_MEMBER)).getId());
            String orderNum = time + user + userTemp;
            if (orderNum.length() >= CreditConstant.CONST_ORDER_MAXLENGTH) {
                orderNum = orderNum.substring(0, CreditConstant.CONST_ORDER_MAXLENGTH);
            }
            creditOrderVO.setOrderNum(orderNum);
            if (creditOrderProjectVO.getSupportPrice() == null) {
                creditOrderProjectVO.setSupportPrice(0);
            }
            Double sumMoney = (double) (creditOrderProjectVO.getFreight() + creditOrderProjectVO.getSupportPrice() * creditOrderProjectVO.getReturnCount());
            creditOrderVO.setOrderAmount(sumMoney);
            String subject = creditOrderProjectVO.getProjectName();
            if (subject == null) {
                subject = "subject";
            }
            if (sumMoney < 0) {
                sumMoney = 1.0;
            }
            String body = creditOrderProjectVO.getReturnContent();
            session.setAttribute("CreditOrderVO", creditOrderVO);
            logger.info(creditOrderVO.toString());
            return useAlipay(orderNum, String.valueOf(sumMoney), subject, body);
        }
        return "redirect://localhost:81";
    }

    private String useAlipay(String out_trade_no, String total_amount, String subject, String body) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(payConfig.getGatewayUrl(), payConfig.getAppId(), payConfig.getMerchantPrivateKey(), "json", payConfig.getCharset(), payConfig.getAlipayPublicKey(), payConfig.getSignType());
        logger.info(alipayClient.toString());
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        String return_url = "http://localhost:81" + payConfig.getReturnUrl();
        String notify_url = payConfig.getMainUrl() + payConfig.getNotifyUrl();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //输出
        return result;
    }

}
