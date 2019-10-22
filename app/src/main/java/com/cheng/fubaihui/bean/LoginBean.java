package com.cheng.fubaihui.bean;

/**
 * Remember to smile every day
 * Author xd
 * Time 2019/10/22
 */
public class LoginBean {

    /**
     * code : 200
     * msg : 登录成功
     * data : {"uid":1126,"user_type":0}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 1126
         * user_type : 0
         */

        private int uid;
        private int user_type;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }
    }
}
