package com.cxy.ocrDemo.common.util.baidu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

/**
 * Base64 工具类
 */
public class Base64Util {
    private static final char last2byte = (char) Integer.parseInt("00000011", 2);
    private static final char last4byte = (char) Integer.parseInt("00001111", 2);
    private static final char last6byte = (char) Integer.parseInt("00111111", 2);
    private static final char lead6byte = (char) Integer.parseInt("11111100", 2);
    private static final char lead4byte = (char) Integer.parseInt("11110000", 2);
    private static final char lead2byte = (char) Integer.parseInt("11000000", 2);
    private static final char[] encodeTable = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public Base64Util() {
    }

    public static String encode(byte[] from) {
        StringBuilder to = new StringBuilder((int) ((double) from.length * 1.34D) + 3);
        int num = 0;
        char currentByte = 0;

        int i;
        for (i = 0; i < from.length; ++i) {
            for (num %= 8; num < 8; num += 6) {
                switch (num) {
                    case 0:
                        currentByte = (char) (from[i] & lead6byte);
                        currentByte = (char) (currentByte >>> 2);
                    case 1:
                    case 3:
                    case 5:
                    default:
                        break;
                    case 2:
                        currentByte = (char) (from[i] & last6byte);
                        break;
                    case 4:
                        currentByte = (char) (from[i] & last4byte);
                        currentByte = (char) (currentByte << 2);
                        if (i + 1 < from.length) {
                            currentByte = (char) (currentByte | (from[i + 1] & lead2byte) >>> 6);
                        }
                        break;
                    case 6:
                        currentByte = (char) (from[i] & last2byte);
                        currentByte = (char) (currentByte << 4);
                        if (i + 1 < from.length) {
                            currentByte = (char) (currentByte | (from[i + 1] & lead4byte) >>> 4);
                        }
                }

                to.append(encodeTable[currentByte]);
            }
        }

        if (to.length() % 4 != 0) {
            for (i = 4 - to.length() % 4; i > 0; --i) {
                to.append("=");
            }
        }

        return to.toString();
    }

    /**
     * base64转为图片
     * @param path
     * 文件路径：到文件夹即可，代码里会在文件夹里生成对应的jpg文件
     * @param base64
     * @return
     */
    public static String base64ToJpg(String path,String base64){
        // 判断文件路径是否存在
        File filePath = new File(path);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        // 创建文件
        String jpgFile = path + "\\" + UUID.randomUUID() + ".jpg";
        File file = new File(jpgFile);
        boolean jpgFileExist = false;
        try {
            jpgFileExist = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jpgFileExist){
            // 解密
            Base64.Decoder decoder = Base64.getDecoder();
            // 去掉base64前缀 data:image/jpeg;base64,
            if(base64.contains("data:image/jpeg;base64")){
                base64 = base64.substring(base64.indexOf(",", 1) + 1, base64.length());
            }
            byte[] b = decoder.decode(base64);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 保存图片
            try {
                FileOutputStream out = new FileOutputStream(jpgFile);
                out.write(b);
                out.flush();
                out.close();
                // 写入成功返回文件路径
                return jpgFile;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "文件不存在";
    }

}
