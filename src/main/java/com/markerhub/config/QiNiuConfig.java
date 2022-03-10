package com.markerhub.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Date：2022/2/10
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Component
@ConfigurationProperties("qiniu")
@Data
public class QiNiuConfig {

    private String accessKey;

    private String secretKey;

    private String bucket;

}
