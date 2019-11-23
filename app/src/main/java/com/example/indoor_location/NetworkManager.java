package com.example.indoor_location;

import java.util.ArrayList;
import java.util.List;

public class NetworkManager {
    List<Network> networks;

    public NetworkManager(){
        networks = new ArrayList<>();
    }

    public List<Network> getNetworksHardcode() {
        networks.add(new Network("UTEC Ventures", "10:2C:44:33:3A:B7", 230));
        networks.add(new Network("UTEC Edux", "01:1B:43:10:1A:E7", 456));
        networks.add(new Network("UTEC Alumnos", "10:1B:44:00:3A:d5", 342));
        networks.add(new Network("GEH-Personal", "11:1C:44:11:3A:B7", 645));
        networks.add(new Network("UTEC Eventos", "00:1B:44:11:3A:B7", 459));
        return networks;
    }

    public List<Network> getNetworks(){
        return networks;
    }
}
