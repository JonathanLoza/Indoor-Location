package com.example.indoor_location;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class DatabaseEvent implements ValueEventListener {
    LocationBottomSheet bottomSheet;

    DatabaseEvent(LocationBottomSheet bottomSheet) {
        this.bottomSheet = bottomSheet;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (!dataSnapshot.exists()) {
            bottomSheet.setText("Unrecognized");
            return;
        }

        String place = dataSnapshot.getValue(String.class);
        bottomSheet.setText(place);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
