package com.sit305.task51c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopDescRecyclerViewAdap extends RecyclerView.Adapter<TopDescRecyclerViewAdap.ViewHolder>{

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
        holder.desc_IV.setImageResource(placesList.get(position).getImageFile());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = placesList.get(position).getId();
                // Call the fragment with the ID of this item.
            }
        });
    }

    @Override
    public int getItemCount() { return placesList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView desc_IV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desc_IV = itemView.findViewById(R.id.desc_IV);
        }
    }
}
