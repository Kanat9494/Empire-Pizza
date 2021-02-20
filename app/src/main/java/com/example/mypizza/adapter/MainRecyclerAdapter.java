package com.example.mypizza.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypizza.MainActivity;
import com.example.mypizza.R;
import com.example.mypizza.model.AllCategory;
import com.example.mypizza.model.Model;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private Context context;
    private List<AllCategory> allCategoryList;
    List<Model> mList;


    public MainRecyclerAdapter(MainActivity mainActivity, List<AllCategory> allCategoryList) {
    }

    public MainRecyclerAdapter(List<Model> mList, Context context) {
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView2);
        }
    }
}
