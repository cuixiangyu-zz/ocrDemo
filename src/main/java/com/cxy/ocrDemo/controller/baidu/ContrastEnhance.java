package com.cxy.ocrDemo.controller.baidu;

import com.alibaba.fastjson.JSONObject;
import com.cxy.ocrDemo.common.util.baidu.Base64Util;
import com.cxy.ocrDemo.common.util.baidu.FileUtil;
import com.cxy.ocrDemo.common.util.baidu.HttpUtil;

import java.io.IOException;
import java.net.URLEncoder;

/**
* 图像对比度增强
*/
public class ContrastEnhance {

    private final static String accessToken = "24.222d8e986a5dce45288f9b8a8279bce6.2592000.1687621006.282335-33990449";

    public static void dealImg(String imgAddr){
        //String filePath = "D:\\公司文件\\ocr\\pic\\answer_1.jpg";
        byte[] imgData = new byte[0];
        try {
            imgData = FileUtil.readFileByBytes(imgAddr);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String first = image_quality_enhance(imgParam);
            Thread.sleep(1000);
            String second = image_definition_enhance(first);
            Thread.sleep(1000);
            String third = contrast_enhance(second);
            Base64Util.base64ToJpg("D:\\公司文件\\ocr\\pic",third);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * 对比度增强
     * @return
     */
    public static String contrast_enhance(String imgParam) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-process/v1/contrast_enhance";
        try {
            // 本地文件路径
            /*String filePath = "D:\\公司文件\\ocr\\pic\\answer_1.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");*/

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "24.c6fc08f9bf7ca0ee7b24dcd2f7e740dc.2592000.1687619531.282335-33989578";

            String result = HttpUtil.post(url, accessToken, param);
            JSONObject object = JSONObject.parseObject(result);
            System.out.println(result);
            return object.getString("image");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图片放大2倍
     * @return
     */
    public static String image_quality_enhance(String imgParam) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-process/v1/image_quality_enhance";
        try {
            // 本地文件路径
            /*String filePath = "[本地文件路径]";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");*/

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            JSONObject object = JSONObject.parseObject(result);
            System.out.println(result);
            return object.getString("image");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 清晰度增强
     * @return
     */
    public static String image_definition_enhance(String imgParam) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-process/v1/image_definition_enhance";
        try {
            // 本地文件路径
            /*String filePath = "[本地文件路径]";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");*/

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            JSONObject object = JSONObject.parseObject(result);
            System.out.println(result);
            return object.getString("image");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
