package com.example.indoor_location;

public class Network {
    private String mac;
    private String nombre;
    private int rssi;
    private double distance;

    public Network(String nombre,String mac, int rssi,double distance) {
        this.mac = mac;
        this.nombre = nombre;
        this.rssi = rssi;
        this.distance = distance;
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

    public double getDistance(){return distance;}
}
