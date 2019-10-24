package com.study.hong.knowledgecommon;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.hong.knowledgecommon.base.ListBean;

import java.util.ArrayList;

/**
 * Created by hong on 2019/10/24.
 */

public class MianAdapter extends RecyclerView.Adapter<MianAdapter.MainViewHolder> {
    private final Context mContext;
    private final ArrayList<ListBean> listBeans;

    public MianAdapter(ArrayList<ListBean> listBeans, Context context) {
        this.mContext = context;
        this.listBeans = listBeans;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.mian_adapter, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
//        for (Map.Entry<String, Class> arg:map.entrySet()){
//            holder.textView.setText(arg.getKey());
//        }
        holder.textView.setText(listBeans.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, listBeans.get(position).getClassName().getClass());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
