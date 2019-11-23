package com.example.indoor_location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class IndoorLocationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WifiAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button buttonOpenBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_location);

        buttonOpenBottomSheet = findViewById(R.id.locate);
        buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationBottomSheet bottomSheet = new LocationBottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"bs");
            }
        });

        NetworkManager manager = new NetworkManager();

        List<Network> items = manager.getNetworksHardcode();

        recyclerView = (RecyclerView) findViewById(R.id.rvWifi);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new WifiAdapter(items);
        recyclerView.setAdapter(mAdapter);
    }
}
