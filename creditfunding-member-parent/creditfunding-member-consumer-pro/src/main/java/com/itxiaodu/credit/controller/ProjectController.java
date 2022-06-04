package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.api.MysqlService;
import com.itxiaodu.credit.api.RedisService;
import com.itxiaodu.credit.config.ConfigOSS;
import com.itxiaodu.credit.entity.po.MemberConfirmInfoPO;
import com.itxiaodu.credit.entity.vo.*;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.OSSUtils;
import com.itxiaodu.credit.utils.ResultType;
import feign.form.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    public ProjectController() {

    }

    @Autowired
    private ConfigOSS configOSS;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MysqlService mySQLService;

    //    @RequestMapping("/project/ok")
//    public String getHead(){
//        return "redirect:http://localhost:81";
//    }
    @RequestMapping("/create/project/information")
    public String uploadProjectInformation(ProjectVO projectVO, MultipartFile headerPicture,
                                           List<MultipartFile> detailPictureList, HttpSession httpSession,
                                           ModelMap modelMap) throws IOException {
        if (projectVO.getTagIdList() == null || projectVO.getTagIdList().isEmpty()) {
            return "project-launch";
        }
        if (!headerPicture.isEmpty()) {
            if (detailPictureList == null || detailPictureList.isEmpty()) {
                modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_UPLOAD_PICTURE_FAILED);
                return "project-launch";
            }
            ResultType<String> uploadFile = OSSUtils.OSSUploadFile(configOSS.getEndPoint(), configOSS.getBucketName(), configOSS.getAccessKeyId(), configOSS.getAccessKeySecret(), configOSS.getBucketDomain(), headerPicture.getInputStream()
                    , headerPicture.getOriginalFilename());
            if (uploadFile.isSuccess()) {
                String headerPicturePath = uploadFile.getData();
                projectVO.setHeaderPicturePath(headerPicturePath);
            } else {
                modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_UPLOAD_PICTURE_FAILED);
                return "project-launch";
            }
            List<String> detailPicturePathList = new ArrayList<>();
            for (MultipartFile detailPicture : detailPictureList) {
                if (!detailPicture.isEmpty()) {
                    ResultType<String> uploadPicture = OSSUtils.OSSUploadFile(configOSS.getEndPoint(), configOSS.getBucketName(), configOSS.getAccessKeyId(), configOSS.getAccessKeySecret(), configOSS.getBucketDomain(), headerPicture.getInputStream()
                            , detailPicture.getOriginalFilename());
                    if (uploadPicture.isSuccess()) {
                        detailPicturePathList.add(uploadPicture.getData());
                    }
                } else {
                    modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_UPLOAD_PICTURE_FAILED);
                    return "project-launch";
                }
            }
            if (!detailPicturePathList.isEmpty()) {
                projectVO.setDetailPicturePathList(detailPicturePathList);
            }
            httpSession.setAttribute(CreditConstant.CONST_PROJECTVO, projectVO);
            return "redirect:http://localhost:81/project/return/info/page";
        }
        modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_UPLOAD_PICTURE_FAILED);
        return "project-launch";
    }

    @ResponseBody
    @RequestMapping("/create/upload/return/picture.json")
    public ResultType<String> uploadReturnPicture(@RequestParam("returnPicture") MultipartFile returnPicture) {
        try {
            ResultType<String> result = OSSUtils.OSSUploadFile(configOSS.getEndPoint(), configOSS.getBucketName(), configOSS.getAccessKeyId(), configOSS.getAccessKeySecret(), configOSS.getBucketDomain(), returnPicture.getInputStream()
                    , returnPicture.getOriginalFilename());
//            System.out.println("上传成功！！");
            return ResultType.successWithData(result.getData());
        } catch (IOException e) {
            return ResultType.fail(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/create/save/return.json")
    public ResultType<String> saveReturn(MessageReturnVO returnVO, HttpSession session) {
        ProjectVO projectVO = (ProjectVO) session.getAttribute(CreditConstant.CONST_PROJECTVO);
        if (projectVO == null) {
            return ResultType.fail(CreditConstant.CONST_PROJECT_NULL);
        }
        List<MessageReturnVO> messageReturnList = projectVO.getMessageReturnList();
        if (messageReturnList == null || messageReturnList.isEmpty()) {
            messageReturnList = new ArrayList<>();
//            return ResultType.fail(CreditConstant.CONST_MESSAGE_RETURN_NULL);
            projectVO.setMessageReturnList(messageReturnList);
        }
        messageReturnList.add(returnVO);
        session.setAttribute(CreditConstant.CONST_PROJECTVO, projectVO);
//        System.out.println(projectVO.toString());
        return ResultType.successWithoutData();
    }

    @RequestMapping("/create/confirm")
    public String saveConfirm(MemberConfirmInfoVO memberConfirmInfoVO, HttpSession session, ModelMap modelMap) {
        ProjectVO projectVO = (ProjectVO) session.getAttribute(CreditConstant.CONST_PROJECTVO);
        if (projectVO == null) {
            throw new RuntimeException(CreditConstant.CONST_PROJECT_NULL);
        }
        projectVO.setMemberConfirmInfoVO(memberConfirmInfoVO);
        MemberLoginvo memberLoginvo = (MemberLoginvo) session.getAttribute(CreditConstant.CONST_LOGIN_MEMBER);
        Integer memberId = memberLoginvo.getId();
        ResultType<String> result = mySQLService.saveProjectVORemote(projectVO, memberId);
        if (!result.isSuccess()) {
            modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, result.getMessage());
            return "project-confirm";
        }
        return "redirect:http://localhost:81/project/create/success";
    }
    @RequestMapping("/select/detail/project/vo/{id}")
    public String selectDetailProjectVO(@PathVariable("id") Integer id,ModelMap modelMap){
        ResultType<DetailProjectVO> detailProjectVOResultType = mySQLService.selectDetailProjectVORemote(id);
        if (detailProjectVOResultType.isSuccess()){
            DetailProjectVO data = detailProjectVOResultType.getData();
            modelMap.addAttribute("detailProjectVO",data);
        }
        return "project-show-detail";
    }

//    @RequestMapping("/agree/page")
//    public String agreePage(HttpServletRequest request){
////        httpSession.invalidate();
//
//        HttpSession session = request.getSession();
//        MemberLoginvo attribute = (MemberLoginvo) session.getAttribute(CreditConstant.CONST_LOGIN_MEMBER);
//        System.out.println(session.getId());
//        System.out.println(attribute);
//        if (attribute==null){
//            return "redirect:http://localhost:81/auth/member/to/login/page";
//        }
//        return "redirect:http://localhost:81/project/agree/protocol/page";
//    }

}
