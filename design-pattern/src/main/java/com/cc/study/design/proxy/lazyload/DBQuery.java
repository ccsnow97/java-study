package com.cc.study.design.proxy.lazyload;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:25
 * @Modifeid By:
 */
public class DBQuery implements IDBQuery {
    public DBQuery(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String request() {
        return "dbquery request string";
    }
}
