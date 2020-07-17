package com.itmck.hutools;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author it_mck
 * @version V1.0
 * @Package com.itmck.hutools
 * @date 2020/7/17 22:44
 */
public class DES {

    private static Key key;
    //设置密钥key
    private static String KEY_STR = "myKey";
    private static String CHARSETNAME = "UTF-8";
    private static String ALGORITHM = "DES";

    static {
        try {
            //生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            //运用SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            //设置密钥种子
            secureRandom.setSeed(KEY_STR.getBytes());
            //初始化基于SHA1的算法对象
            generator.init(secureRandom);
            //生成密钥对象
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //加密函数
    public static String getEncryptString(String str) {
        BASE64Encoder base64encoder = new BASE64Encoder();
        try {
            //按utf-8编码
            byte[] bytes = str.getBytes(CHARSETNAME);
            //获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化加密信息
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //加密
            byte[] doFinal = cipher.doFinal(bytes);
            //byte to encode好的String返回
            return base64encoder.encode(doFinal);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

    //解密函数
    public static String getDecryptString(String str) {
        //接受byte[]并转换成String
        BASE64Decoder base64decoder = new BASE64Decoder();
        try {
            //将String变成byte
            byte[] bytes = base64decoder.decodeBuffer(str);
            //获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化解密信息
            cipher.init(Cipher.DECRYPT_MODE, key);
            //解密
            byte[] doFinal = cipher.doFinal(bytes);
            //返回解密信息
            return new String(doFinal, CHARSETNAME);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

    //测试
    public static void main(String[] args) {
        System.out.println("加密前：" + "321321390--.p['a>d.zsd[a.?DASdas890-s9d-0qdmas.mxczlcjzlxcnzlxkcnxzkjchajksdnjklnczxkoch9-ajadn;klmczxl;cnzxiophz觉得我气魄低级趣味的节温器豆皮弯曲度亲我赌气我武器");
        String root = getEncryptString("321321390--.p['a>d.zsd[a.?DASdas890-s9d-0qdmas.mxczlcjzlxcnzlxkcnxzkjchajksdnjklnczxkoch9-ajadn;klmczxl;cnzxiophz觉得我气魄低级趣味的节温器豆皮弯曲度亲我赌气我武器");
        System.out.println("加密后：" + root);
        System.out.println("解密后：" + getDecryptString(root));
    }

}
