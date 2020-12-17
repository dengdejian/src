package com.example.my_things.conteact;

import com.example.my_things.net.INetCallBack;

public class MainContract {
    public interface IMainModel {
        <T> void getLoginData(String url, INetCallBack<T> callBack);
    }
    public  interface IMainPresenter {
        void login(String url);
    }
    public interface IMainView {

        <T> void loginRelt(T t);
    }
}
