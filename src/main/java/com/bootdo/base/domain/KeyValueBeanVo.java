package com.bootdo.base.domain;

/**
 * Created by liujie01 on 2019/7/15.
 * key value
 */
public class KeyValueBeanVo {

    private String key;

    private String value;

    public KeyValueBeanVo(String key,String value){
       this.key=key;
       this.value=value;
    }
    public KeyValueBeanVo() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
