package com.sit305.task51c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView topDestinations_RV;
    RecyclerView placesToGo_RV;
    TopDescRecyclerViewAdap topDescRecyclerViewAdap;
    PlacesToGoRecyclerViewAdapter placesToGoRecyclerViewAdapter;

    // To store the places information.
    List<Places> placesList = new ArrayList<>();

    // Create the list of places with their data.
    int[] imageList = {R.drawable.holiday_placeholder, R.drawable.winter_wonderland, R.drawable.sydney, R.drawable.london, R.drawable.treehouse, R.drawable.space_hotel};
    String[] titleList = {"White Sand Island", "Mount Snows-A-lot", "Sydney", "London", "Tree House", "Space Hotel"};
    String[] descriptionList = {"Summer holiday at the brightest sand around.", "Come to this winter wonderland, where it snows every day.",
            "It has a bridge!", "Lots of old timey buildings and history.",
            "Come to the jungle, Hope you're not scared of heights.", "It's in outerspace, enough said."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the recycler views.
        topDestinations_RV = findViewById(R.id.topDestinations_RV);
        placesToGo_RV = findViewById(R.id.placesToGo_RV);

        // Build the list.
        for (int i = 0 ; i < titleList.length; i++ ) {
            Places place = new Places(i, imageList[i], titleList[i], descriptionList[i]);
            placesList.add(place);
        }

        // Build the top des recycler view
        topDescRecyclerViewAdap = new TopDescRecyclerViewAdap(placesList, this);
        topDestinations_RV.setAdapter(topDescRecyclerViewAdap);
        topDestinations_RV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Build the places to go list.
        placesToGoRecyclerViewAdapter = new PlacesToGoRecyclerViewAdapter(placesList, this);
        placesToGo_RV.setAdapter(placesToGoRecyclerViewAdapter);
        placesToGo_RV.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickShowSelection(View view) {

        // Get the ID of the view that was clicked.
        int viewID = view.getId();

        // Create a new new bundle pass the correct information to the fragment.
        Bundle bundle = new Bundle();
        bundle.putInt("VIEW_IMAGE", imageList[viewID]);
        bundle.putString("VIEW_TITLE", titleList[viewID]);
        bundle.putString("VIEW_DESCRIPTION", descriptionList[viewID]);

        // Create a new fragment.
        Fragment fragment;
        fragment = new PlacesFragment();

        // Pass the information.
        fragment.setArguments(bundle);

        // Start the fragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add fragment to the back of the stack to go back if the user clicks the back button.
        fragmentTransaction.replace(R.id.fragment, fragment)
                .addToBackStack(null).commit();
    }
}