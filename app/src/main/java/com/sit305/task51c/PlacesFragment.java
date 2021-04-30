package com.sit305.task51c;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment {

    // Information that will be passed to the fragment to will be set in the onCreateView method
    private int placeImage;
    private String placeTitle;
    private String placeDescription;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If the arguments are not null, get the data needed.
        if (getArguments() != null) {
            placeImage = getArguments().getInt("VIEW_IMAGE");
            placeTitle = getArguments().getString("VIEW_TITLE");
            placeDescription = getArguments().getString("VIEW_DESCRIPTION");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new layout inflater.
        LayoutInflater lf = getActivity().getLayoutInflater();

        // Create the view from the layout inflater, using the place's fragment.
        View view =  lf.inflate(R.layout.fragment_places, container, false); //pass the correct layout name for the fragment

        // Get all the views inside the layout.
        ImageView imageResource = (ImageView) view.findViewById(R.id.fragPlace_IV);
        TextView titleText = (TextView) view.findViewById(R.id.fragPlaceTitle_TV);
        TextView descriptionText = (TextView) view.findViewById(R.id.fragPlaceDesc_TV);

        // Set the required data from the passed arguments.
        imageResource.setImageResource(placeImage);
        descriptionText.setText(placeDescription);
        titleText.setText(placeTitle);

        // Return the newly created view.
        return view;
    }
}