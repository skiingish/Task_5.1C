package com.sit305.task51c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopDescRecyclerViewAdap extends RecyclerView.Adapter<TopDescRecyclerViewAdap.ViewHolder>{

    // The list of places.
    private List<Places> placesList;
    private Context context;


    public TopDescRecyclerViewAdap(List<Places> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
    }


    @NonNull
    @Override
    public TopDescRecyclerViewAdap.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_destinations_row, parent, false);

        return new ViewHolder(itemView);
    }

    // Set the data
    @Override
    public void onBindViewHolder(@NonNull TopDescRecyclerViewAdap.ViewHolder holder, int position) {

        // Set the image.
        holder.desc_IV.setImageResource(placesList.get(position).getImageFile());

        // Set the id of this image view depending on it's places list ID.
        holder.desc_IV.setId(placesList.get(position).getId());
    }

    @Override
    public int getItemCount() { return placesList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // The image view.
        ImageView desc_IV;

        // Get the image view.
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desc_IV = itemView.findViewById(R.id.desc_IV);
        }
    }
}
