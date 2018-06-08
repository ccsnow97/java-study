package com.cc.study.design.proxy.lazyload;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:27
 * @Modifeid By:
 */
public class DBQueryProxy implements IDBQuery{
    private DBQuery dbQuery=null;

    @Override
    public String request() {
        //在真正需要的时候才创建真是对象，创建过程可能很慢
        if(dbQuery==null){
            dbQuery=new DBQuery();
        }
        return dbQuery.request();
    }
}
