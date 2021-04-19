/*******************************************************************************
 * Copyright (c) 2021. Aquad
 * Sören Dominik Kruck
 * Alias: Doerte
 ******************************************************************************/

package com.doerte.base;

import com.doerte.actions.Action;
import com.doerte.base.Data.DataPackage;

import java.io.IOException;
import java.net.Socket;

public class Sender {

    public String destinationIP;
    public String ownIP;
    public int port;

    public Socket socket;

    public static final String LOCALHOST = "127.0.0.1";
    public static final int DEFAULT_PORT = 5346;

    public boolean printStatus = false;

    public Sender(String destIP, int port) {
        setupSocket(destIP, port);
    }

    public Sender(int port) {
        setupSocket(LOCALHOST, port);
    }

    public Sender(String destinationIP) {
        setupSocket(destinationIP, DEFAULT_PORT);
    }

    public Sender() {
        setupSocket(LOCALHOST, DEFAULT_PORT);
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public void setDestinationIP(String destinationIP) {
        this.destinationIP = destinationIP;
    }

    public String getOwnIP() {
        return ownIP;
    }

    public void setOwnIP(String ownIP) {
        this.ownIP = ownIP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(boolean printStatus) {
        this.printStatus = printStatus;
    }

    private void setupSocket(String destinationIP, int port) {
        this.destinationIP = destinationIP;
        this.port = port;

        this.ownIP = Hub.getOwnIPV4Adress();

        try {
            socket = new Socket(this.destinationIP, this.port);
            if (printStatus)
                System.out.println("Socket attached. Destination ip: " + this.destinationIP + "@" + this.port);
        } catch (IOException e) {
            e.printStackTrace();
            if (printStatus) {
                System.err.println("Error due setting up Socket");
                System.err.println("Eventually the server isn't reachable.");
            }
        }
    }

    public void restart() {
        setupSocket(this.destinationIP, this.port);
    }

    public boolean transmitDataPackage(DataPackage dataPackage) {
        // TODO: Implement method.
        return true;
    }

}
