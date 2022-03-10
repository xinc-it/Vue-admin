package com.markerhub.controller;

import com.markerhub.common.lang.Result;
import com.markerhub.config.QiNiuConfig;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date：2022/2/10
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/up")
public class UploadController {



    @Autowired
    private QiNiuConfig qiNiuConfig;
    /**
     * 获取七牛云上传TOKEN
     * @return
     */
    @GetMapping("/token")
    public Result getQiuYunToken(){
        String accessKey = qiNiuConfig.getAccessKey();
        String secretKey = qiNiuConfig.getSecretKey();
        String bucket = qiNiuConfig.getBucket();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return Result.succ(upToken);
    }

}
