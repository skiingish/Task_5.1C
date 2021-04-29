package com.sit305.task51c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlacesToGoRecyclerViewAdapter extends RecyclerView.Adapter<PlacesToGoRecyclerViewAdapter.ViewHolder>{

    private List<Places> placesList;
    private Context context;

    public PlacesToGoRecyclerViewAdapter(List<Places> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
    }

    // When the view is created.
    @NonNull
    @Override
    public PlacesToGoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.places_to_go_column, parent, false);

        return new ViewHolder(itemView);
    }

    // Add the data in.
    @Override
    public void onBindViewHolder(@NonNull PlacesToGoRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.placesToGo_IV.setImageResource(placesList.get(position).getImageFile());
        holder.placeToGoTitle_TV.setText(placesList.get(position).getTitle());
        holder.shortDesc_TV.setText(placesList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    // Gets the text views to be added to the view holder.
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView placesToGo_IV;
        TextView placeToGoTitle_TV;
        TextView shortDesc_TV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placesToGo_IV = itemView.findViewById(R.id.placesToGo_IV);
            placeToGoTitle_TV = itemView.findViewById(R.id.placeToGoTitle_TV);
            shortDesc_TV = itemView.findViewById(R.id.shortDesc_TV);
        }
    }
}
