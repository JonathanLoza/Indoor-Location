package com.example.indoor_location;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class DatabaseEvent implements ValueEventListener {
    private String mac;
    TextView placeView;

    DatabaseEvent(String mac, TextView placeView) {
        this.mac = mac;
        this.placeView = placeView;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String place = dataSnapshot.getValue(String.class);
        placeView.setText(place);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
