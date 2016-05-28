package gov.nasa.farmars.server.send;

import gov.nasa.farmars.server.HttpServer;

/**
 * Created by nick on 28.05.16.
 */
public class SendToServer {

    private void send() {

    }

    public void setParams(boolean airTemp, boolean airHumidity,
                          boolean groundTemp, boolean groundHumidity,
                          boolean oxygen, boolean lamp) {



    }

    public void turnLamp(boolean on) {
        HttpServer.sendToArduino("Turn on lamp");
    }

    public void turnAir(boolean on) {

    }

    public void turnHumidity(boolean on) {

    }
}
