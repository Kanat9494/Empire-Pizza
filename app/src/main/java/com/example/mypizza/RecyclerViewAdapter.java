package com.example.mypizza;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private ArrayList<RecyclerViewItem> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView tvNewsTitle;
        public TextView tvNewsSubtitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.news_image_view);
            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            tvNewsSubtitle = itemView.findViewById(R.id.tv_news_subtitle);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.home_recycler_view_items,
                        parent,
                        false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecyclerViewItem recyclerViewItem = arrayList.get(position);

        holder.imageView.setImageResource(recyclerViewItem.getImageResource());
        holder.tvNewsTitle.setText(recyclerViewItem.getTitleNews());
        holder.tvNewsSubtitle.setText(recyclerViewItem.getSubtitleNews());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
