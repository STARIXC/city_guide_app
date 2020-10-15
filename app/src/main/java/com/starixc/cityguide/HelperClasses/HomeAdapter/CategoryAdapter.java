package com.starixc.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.starixc.cityguide.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<CategoryHelperClass> categoryList;
    public CategoryAdapter(ArrayList<CategoryHelperClass> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryHelperClass categoryHelperClass = categoryList.get(position);
        holder.cat_img.setImageResource(categoryHelperClass.getImage());
        holder.cat_title.setText(categoryHelperClass.getCat_title());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static  class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView cat_img;
        TextView cat_title;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cat_img = itemView.findViewById(R.id.cat_image);
            cat_title= itemView.findViewById(R.id.cat_title);
        }
    }
}
