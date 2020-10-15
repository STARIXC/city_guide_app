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

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {
    ArrayList<MostViewedHelperClass> mostviewedLocation;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostviewedLocation) {
        this.mostviewedLocation = mostviewedLocation;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_design,parent,false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewedHelperClass mostViewedHelperClass = mostviewedLocation.get(position);
        holder.ms_img.setImageResource(mostViewedHelperClass.getImage());
        holder.ms_title.setText(mostViewedHelperClass.getTitle());
        holder.ms_desc.setText(mostViewedHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostviewedLocation.size();
    }

    public static class MostViewedViewHolder extends  RecyclerView.ViewHolder{
    ImageView ms_img;
    TextView ms_title,ms_desc;
        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            ms_img = itemView.findViewById(R.id.ms_image);
            ms_title= itemView.findViewById(R.id.ms_title);
            ms_desc = itemView.findViewById(R.id.ms_desc);
        }
    }

}
