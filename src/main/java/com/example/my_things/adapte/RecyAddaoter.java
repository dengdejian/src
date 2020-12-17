package com.example.my_things.adapte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.my_things.R;
import com.example.my_things.model.UserBean;

import java.util.ArrayList;

public class RecyAddaoter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<UserBean.NewsBean> list;

    public RecyAddaoter(Context context, ArrayList<UserBean.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.buju, parent, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserBean.NewsBean newsBean = list.get(position);
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        Glide.with(context).load(newsBean.getImageUrl()).into(viewHolder1.iimg_a);
        viewHolder1.tex_a.setText(newsBean.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView iimg_a;
        private final TextView tex_a;

        public ViewHolder1(View inflate) {
            super(inflate);
            iimg_a = inflate.findViewById(R.id.iimg_a);
            tex_a = inflate.findViewById(R.id.tex_a);
        }
    }
}
