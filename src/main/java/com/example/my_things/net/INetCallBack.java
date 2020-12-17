package com.example.my_things.net;

public interface INetCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String err);
}
