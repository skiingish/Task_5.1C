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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int placeImage;
    private String placeTitle;
    private String placeDescription;
    //TextView placeTitle;

    public PlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacesFragment newInstance(String param1, String param2) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            placeImage = getArguments().getInt("VIEW_IMAGE");
            placeTitle = getArguments().getString("VIEW_TITLE");
            placeDescription = getArguments().getString("VIEW_DESCRIPTION");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_places, container, false); //pass the correct layout name for the fragment

        ImageView imageResource = (ImageView) view.findViewById(R.id.fragPlace_IV);
        TextView titleText = (TextView) view.findViewById(R.id.fragPlaceTitle_TV);
        TextView descriptionText = (TextView) view.findViewById(R.id.fragPlaceDesc_TV);

        imageResource.setImageResource(placeImage);
        descriptionText.setText(placeDescription);
        titleText.setText(placeTitle);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView placeTitle = (TextView) getView().findViewById(R.id.fragPlaceTitle_TV);
        // or  (ImageView) view.findViewById(R.id.foo);
        //placeTitle.setText(placesID);
    }
}