package com.iotmars.config;

import com.iotmars.util.RsaUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * @author: xsh
 * @date: 2020/11/27 13:31
 */
@Data
@Component
@Configuration
public class JwtConfig {

    @Value("${jwt.publicKeyFile}")
    private String publicKeyFile;


    private PublicKey publicKey;


    @PostConstruct
    public void getKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(publicKeyFile);
    }

    public String getPublicKeyFile() {
        return publicKeyFile;
    }

    public void setPublicKeyFile(String publicKeyFile) {
        this.publicKeyFile = publicKeyFile;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

}
