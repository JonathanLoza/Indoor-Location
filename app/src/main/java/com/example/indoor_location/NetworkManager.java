package com.example.indoor_location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NetworkManager extends BroadcastReceiver {
    private static final double DISTANCE_MHZ_M = 27.55;
    public List<Network> networks;
    WifiManager wifiManager;
    private WifiAdapter mAdapter;
    private RecyclerView recyclerView;
    StringBuilder sb;

    public NetworkManager(WifiManager wifiManager,RecyclerView recyclerView) {
        this.wifiManager = wifiManager;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            sb = new StringBuilder();
            List<ScanResult> wifiList = wifiManager.getScanResults();
            networks = new ArrayList<>();
            for (ScanResult scanResult : wifiList) {
                //sb.append("\n").append(scanResult.SSID).append(" - ").append(scanResult.capabilities);
                //deviceList.add(scanResult.SSID + " - " + scanResult.capabilities);
                networks.add(new Network(scanResult.SSID,scanResult.BSSID,scanResult.level,calculateDistance(scanResult.frequency,scanResult.level)));
            }
            //Toast.makeText(context, sb, Toast.LENGTH_SHORT).show();
            mAdapter = new WifiAdapter(networks);
            //ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, deviceList.toArray());
            //wifiDeviceList.setAdapter(arrayAdapter);
            recyclerView.setAdapter(mAdapter);
        }
    }


    public List<Network> getNetworks(){
        return networks;
    }

    public static double calculateDistance(int frequency, int level) {
        return Math.pow(10.0, (DISTANCE_MHZ_M - (20 * Math.log10(frequency)) + Math.abs(level)) / 20.0);
    }

}
