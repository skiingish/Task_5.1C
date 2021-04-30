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

    List<Places> placesList = new ArrayList<>();

    static int itemClicked;

    int[] imageList = {R.drawable.holiday_placeholder, R.drawable.holiday_placeholder, R.drawable.holiday_placeholder, R.drawable.holiday_placeholder, R.drawable.holiday_placeholder, R.drawable.holiday_placeholder};
    String[] titleList = {"Summer Holiday", "Winter Holiday", "Summer Holiday", "Summer Holiday", "Summer Holiday", "Summer Holiday"};
    String[] descriptionList = {"I am a description of a place to go", "Come to this winter wonderland", "I am a description of a place to go", "I am a description of a place to go", "I am a description of a place to go", "I am a description of a place to go"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the
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
        int viewID = view.getId();
        Toast.makeText(this, "Item ID " + viewID, Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();
        bundle.putInt("VIEW_IMAGE", imageList[viewID]);
        bundle.putString("VIEW_TITLE", titleList[viewID]);
        bundle.putString("VIEW_DESCRIPTION", descriptionList[viewID]);

        Fragment fragment;

        fragment = new PlacesFragment();

        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment, fragment)
                .commit();

    }

    public static void setItemClicked(int itemID) {
        itemClicked = itemID;
    }
}