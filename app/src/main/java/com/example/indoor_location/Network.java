package com.example.indoor_location;

public class Network {
    private String mac;
    private String nombre;
    private int rssi;

    public Network(String nombre,String mac, int rssi) {
        this.mac = mac;
        this.nombre = nombre;
        this.rssi = rssi;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRssi() {
        return rssi;
    }

    public String getMac() {
        return mac;
    }
}
