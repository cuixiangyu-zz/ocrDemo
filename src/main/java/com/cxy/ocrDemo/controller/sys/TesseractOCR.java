package com.cxy.ocrDemo.controller.sys;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class TesseractOCR {
    public static void main(String[] args) {
        // 创建Tesseract实例
        Tesseract tesseract = new Tesseract();

        try {
            // 设置语言模型，可以根据需要设置多个语言
            tesseract.setLanguage("eng");

            // 加载图像
            File imageFile = new File("C:\\Users\\崔祥瑜\\Desktop\\testOcr.jpg");

            // 进行OCR识别
            String result = tesseract.doOCR(imageFile);

            // 处理OCR结果
            System.out.println("OCR Result:\n" + result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
