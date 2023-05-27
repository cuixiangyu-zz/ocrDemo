package com.cxy.ocrDemo.controller.baidu;

import com.baidu.aip.ocr.AipOcr;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;

/**
 * @program: ocrDemo
 * @description: aaa
 * @author: CuiXiangYu
 * @create: 2023-05-24 23:05
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    public static final String APP_ID = "33984823";
    public static final String API_KEY = "kpfcZKK1lA4VeddcrogK3Deo";
    public static final String SECRET_KEY = "srFvycryhcklYFYc6phObViQnrRUZrzb";

    @GetMapping("/testOcr")
    public String testOcr(){

        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "test.jpg";
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("words_type","handwring_only");
        options.put("layout_analysis","true");
        //options.put("language_type","ENG");
        //options.put("result_type","small");
        // 参数为本地图片路径
        String image = "D:\\公司文件\\ocr\\pic\\answer_1.jpg";
        /*JSONObject res = client.docAnalysis(image, options);
        System.out.println(res.toString(2));*/

        ContrastEnhance.contrast_enhance(image);
        return null;
    }
}
