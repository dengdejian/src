package com.example.my_things;

import android.util.Log;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_things.adapte.RecyAddaoter;
import com.example.my_things.api.URLConstant;
import com.example.my_things.base.BaseActivity;
import com.example.my_things.conteact.MainContract;
import com.example.my_things.model.UserBean;
import com.example.my_things.presenter.MainPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {

    private RecyclerView recy;
    private ArrayList<UserBean.NewsBean> list;
    private RecyAddaoter recyAddaoter;

    @Override
    protected MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected void initData() {
        presenter.login(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {
        recy = findViewById(R.id.recy);


        list = new ArrayList<>();
        recyAddaoter = new RecyAddaoter(this, list);
        recy.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(recyAddaoter);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public <T> void loginRelt(T t) {
        UserBean userBean = (UserBean) t;
        List<UserBean.NewsBean> news = userBean.getNews();
        list.addAll(news);
        recyAddaoter.notifyDataSetChanged();

        for (int i = 0; i < news.size(); i++) {
            Log.d("TAG", "loginRelt: " + news.get(i).getContent());
            Log.d("TAG", "loginRelt: " + news.get(i).getImageUrl());
            Log.d("TAG", "loginRelt: " + news.get(i).getTile());
        }

    }
}