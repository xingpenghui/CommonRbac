package com.feri.rbac.vo;

import lombok.Data;

/**
 * @program: BootSsm
 * @description:
 * @author: Feri
 * @create: 2019-10-21 10:28
 */
@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public static R setOK(Object data){
        R r=new R();
        r.setCode(200);
        r.setMsg("OK");
        r.setData(data);
        return r;
    }
    public static R setERROR(){
        R r=new R();
        r.setCode(400);
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }
    public static R setResult(boolean isSuccess,Object obj){
        if(isSuccess){
            return setOK(obj);
        }else {
            return setERROR();
        }
    }
}
