package com.cxy.ocrDemo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: website
 * @description: 常量类
 * @author: CuiXiangYu
 * @create: 2019-11-08 10:16
 **/
@Component
public class CommonStatus {

    public static final Integer ACTOR_TYPE_JAPAN = 1;
    public static final Integer ACTOR_TYPE_AMERICAN = 2;
    public static final Integer ACTOR_TYPE_PICTURE = 3;

    public static final Integer PICTURE_EXIST_EXIST = 1;
    public static final Integer PICTURE_EXIST_DELETE = 2;
    public static final Integer PICTURE_EXIST_NOTINDATABASE = 3;

    public static final Integer IS_VALID_NO = 0;
    public static final Integer IS_VALID_TES = 1;

    public static final Integer IS_DEL_NO = 0;
    public static final Integer IS_DEL_YES = 1;

    public static final Integer VIDEO_TYPE_JAPAN = 1;
    public static final Integer VIDEO_TYPE_AMERICAN = 2;
    public static final Integer VIDEO_TYPE_ANIMATE = 3;
    public static final Integer VIDEO_TYPE_PORN = 4;
    public static final Integer VIDEO_TYPE_MOVIE = 5;
    public static final Integer VIDEO_TYPE_KOREAN = 6;

    public static final Integer VIDEO_EXIST_EXIST = 1;
    public static final Integer VIDEO_EXIST_DELETE = 2;
    public static final Integer VIDEO_EXIST_NOTINDATABASE = 3;

    public static final Integer TYPE_TYPE_JAPAN = 1;
    public static final Integer TYPE_TYPE_AMERICAN = 2;
    public static final Integer TYPE_TYPE_PICTURE = 3;
    public static final Integer TYPE_TYPE_COMIC = 4;
    public static final Integer TYPE_TYPE_ARTIST = 5;

    public static final Integer FAVORITE_HISTORY_TYPE_JAPAN = 1;
    public static final Integer FAVORITE_HISTORY_TYPE_AMERICAN = 2;
    public static final Integer FAVORITE_HISTORY_TYPE_ANIMATE = 3;
    public static final Integer FAVORITE_HISTORY_TYPE_SMALL_VIDEO = 4;
    public static final Integer FAVORITE_HISTORY_TYPE_PICTURE = 5;

    //public static final String FILE_URL_PREFIX = "http://192.168.1.18:5002/website/resources";

    public static final String JAPAN_URL = "https://www.javsee.me//";

    public static final String AMERICAN_URL = "https://www.javbus.red/";

    public static String COVER_URL_PREFIX_NET = "https://www.javsee.me" ;

    public static String FILE_URL_PREFIX ;
    public static String COVER_URL_PREFIX ;
    public static String BASE_SYSTEM_URL ;

    //public static String FILE_COVER_PREFIX = "/mnt/8t-3/COVER";
    public static String FILE_COVER_PREFIX = "E:\\COVER";

    public static final String FILE_LINUX_ADDR = "/mnt";
    public static final String[] WINDOWS_ADDRS = {"L:\\resources/","K:\\resources/","I:\\resource/","H:\\resources/","N:\\resources/"};
    public static final String[] addrs = {"1t-3","2t-1","4t-1","8t-1","8t-2"};

    public static List<String> resourcesAddrs = new ArrayList<>();

    //系统类型:base本地系统,remote远程系统
    public static String SYS_TYPE ;

    //远程系统url
    public static String REMOTE_SYS_URL ;

    //本地系统外网ip
    public static String BASE_SYS_OUT_URL ;

    //本地系统内网ip
    public static String BASE_SYS_INNER_URL ;

    //javbus网站cookie
    public static String COOKIE = "existmag=mag; PHPSESSID=997vf2dlipm9s1ghonqf68lhk4" ;

    //本地porn封面位置
    public static String PORN_IMG_ADDR = "E:\\pornHubImg/";
}
