package com.itmck.hutools;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author it_mck
 * @version V1.0
 * @Package com.itmck.hutools
 * @date 2020/7/14 22:59
 */
public class hutoolTest {

    public static void main(String[] args) {

        String content = "test中文";

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();

        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);

//加密为16进制字符串（Hex表示）
        String encryptHex = des.encryptHex(content);
//解密为字符串
        String decryptStr = des.decryptStr(encryptHex);
    }
}
