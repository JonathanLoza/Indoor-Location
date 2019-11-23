package com.example.indoor_location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IndoorLocationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WifiAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_location);
        List<NetworkManager> items = new ArrayList<NetworkManager>();

        items.add(new NetworkManager("UTEC Ventures", "10:2C:44:33:3A:B7", 230));
        items.add(new NetworkManager("UTEC Edux", "01:1B:43:10:1A:E7", 456));
        items.add(new NetworkManager("UTEC Alumnos", "10:1B:44:00:3A:d5", 342));
        items.add(new NetworkManager("GEH-Personal", "11:1C:44:11:3A:B7", 645));
        items.add(new NetworkManager("UTEC Eventos", "00:1B:44:11:3A:B7", 459));

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
