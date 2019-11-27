package com.example.indoor_location;

import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Repository {
    public static final String MAIN_CHILD = "places";
    private DatabaseReference database;

    Repository() {
        database = FirebaseDatabase.getInstance("https://indoor-location-68a3f.firebaseio.com/").getReference(Repository.MAIN_CHILD);
    }

    void getPlace(String mac, LocationBottomSheet bottomSheet) {
        //database.child("places").child("a0:39:ee:98:fa:f6").setValue("aea");
        database.child(mac).addValueEventListener(new DatabaseEvent(mac, bottomSheet));
    }
}
