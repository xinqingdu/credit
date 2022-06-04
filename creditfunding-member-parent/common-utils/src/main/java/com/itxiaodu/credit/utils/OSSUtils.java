package com.itxiaodu.credit.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

public class OSSUtils {
    OSSUtils() {

    }

    public static ResultType<String> OSSUploadFile(String endPoint,
                                                   String bucketName,
                                                   String accessKeyId,
                                                   String accessKeySecret,
                                                   String bucketDomain,
                                                   InputStream inputStream,
                                                   String fileName) {
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
        String fileDir = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String fileMain = UUID.randomUUID().toString().replace("-", "");
        String fileExName = fileName.substring(fileName.lastIndexOf("."));
        String fileComName=fileDir + "/" + fileMain+fileExName;
        try {
            // 创建PutObject请求。
            ossClient.putObject(bucketName, fileComName, inputStream);
            String path = bucketDomain+"/"+fileComName;
            return ResultType.successWithData(path);
        } catch (OSSException oe) {
            return ResultType.fail(oe.getMessage());
        } catch (ClientException ce) {
            return ResultType.fail(ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}
