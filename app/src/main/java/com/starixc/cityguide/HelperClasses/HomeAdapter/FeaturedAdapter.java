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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHealperClass> featuredLocation;

    public FeaturedAdapter(ArrayList<FeaturedHealperClass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHealperClass featuredHealperClass = featuredLocation.get(position);
        holder.image.setImageResource(featuredHealperClass.getImage());
        holder.title.setText(featuredHealperClass.getTitle());
        holder.desc.setText(featuredHealperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }

    public static  class FeaturedViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks
            image =itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }
}
