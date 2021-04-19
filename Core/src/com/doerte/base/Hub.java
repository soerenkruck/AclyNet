package com.doerte.base;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Hub {

    private String name;
    private int id;
    private String uuid;

    private String ip_v4;

    public Hub(String name, int id, String uuid, String ip_v4) {
        this.name = name;
        this.id = id;
        this.uuid = uuid;
        this.ip_v4 = ip_v4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIp_v4() {
        return ip_v4;
    }

    public void setIp_v4(String ip_v4) {
        this.ip_v4 = ip_v4;
    }

    // Returns IP adress from device
    public static String getOwnIPV4Adress() {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Failed getting IPV4";
        }
    }
}

