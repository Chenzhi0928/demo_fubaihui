package com.cheng.fubaihui.frame;

public class Config {
    public static String BASE_URL;
    private static int type = 1;

    /**
     * 1,外网正式服务器
     * 2，外网测试服务器
     * 3，内网测试服务器
     */
    static {
        if (type == 1){//在一种环境下可能有多个服务器
            BASE_URL = "http://newwasj.zhangtongdongli.com";
        } else if (type == 2){
            BASE_URL = "http://newwasj.zhangtongdongli.com/";
        } else {
            BASE_URL = "http://sina.com/";
        }
    }
}
