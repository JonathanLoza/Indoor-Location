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
                networks.add(new Network(isProtected(scanResult.SSID),scanResult.BSSID,scanResult.level,calculateDistance(scanResult.frequency,scanResult.level)));
            }

            mAdapter = new WifiAdapter(networks);
            recyclerView.setAdapter(mAdapter);
        }
    }


    public List<Network> getNetworks(){
        return networks;
    }

    public static double calculateDistance(int frequency, int level) {
        return Math.pow(10.0, (DISTANCE_MHZ_M - (20 * Math.log10(frequency)) + Math.abs(level)) / 20.0);
    }

    public String isProtected(String SSID){
        System.out.println("SSID: "+SSID);
        if(SSID.equals("")){
            return "Hidden Network";
        }
        return SSID;
    }
}
