package com.iotmars.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RsaUtilsTest {

    private String privateFilePath = "E:\\钥匙\\id_key_rsa";

    private String publiecFilePath = "E:\\钥匙\\id_key_rsa_pub";


    @Test
    void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(publiecFilePath));
    }

    @Test
    void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(privateFilePath));

    }

    @Test
    void generateKey() throws Exception {
        RsaUtils.generateKey(publiecFilePath,privateFilePath,"iotmars",2048);


    }
}