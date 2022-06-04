package com.itxiaodu.credit.utils;

public class ResultType<T> {
    //判断当前请求处理结果正确或错误
    public static final String SUCCESS="success";
    public static final String FAIL="fail";
    private boolean success;
    //请求错误信息
    private String message;
    //放回的数据
    private T data;
    public ResultType() {

    }
    //<Type>声明泛型，function<Type>叫使用泛型
    public static <Type> ResultType<Type> successWithoutData(){
        return new ResultType<Type>(true,null,null);
    }
    public static <Type> ResultType<Type> successWithData(Type data){
        return new ResultType<>(true,null,data);
    }
    public static <Type> ResultType<Type> fail(String message){
        return new ResultType<>(false,message,null);
    }

    public ResultType(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


    public void setResult(boolean result) {
        this.success = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }
}
