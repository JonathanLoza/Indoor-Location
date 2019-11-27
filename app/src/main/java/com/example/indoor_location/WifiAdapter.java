package com.example.indoor_location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WifiAdapter extends RecyclerView.Adapter<WifiAdapter.MyViewHolder> {
    private List<Network> wifi;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView rssi;
        public TextView mac;
        public TextView distance;


        public MyViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombre);
            mac = (TextView) v.findViewById(R.id.mac);
            rssi = (TextView) v.findViewById(R.id.rssi);
            distance = (TextView) v.findViewById(R.id.distance);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WifiAdapter(List<Network> wifi) {
        this.wifi = wifi;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WifiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombre.setText(wifi.get(position).getNombre());
        holder.mac.setText(wifi.get(position).getMac());
        holder.rssi.setText(Integer.toString(wifi.get(position).getRssi()));
        holder.distance.setText(String.format ("%.2f", wifi.get(position).getDistance())+ "" +
                "m");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return wifi.size();
    }
}
