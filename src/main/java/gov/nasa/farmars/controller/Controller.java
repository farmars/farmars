package gov.nasa.farmars.controller;

import gov.nasa.farmars.command.Command;
import gov.nasa.farmars.device.Device;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Controller {

    private String id;
    private Map<String, Device> devices;

    public Controller(String id) {
        this.id = id;
        devices = new HashMap<String, Device>();
    }

    public Controller(String id, Device[] devices) {
        this(id);
        for (Device d : devices) {
            registerDevice(d);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void registerDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public void unregisterDevice(Device device) {
        devices.remove(device.getId());
    }

    public void addCommand(String deviceId, Command c) throws NoSuchDeviceException {
        Device d = devices.get(deviceId);
        if (d == null)
            throw new NoSuchDeviceException(String.format("%s device is not registered with controller %s", deviceId, id));

        d.addCommand(c);
    }

    public JSONArray getDevicesJSON() {
        JSONArray devs = new JSONArray();
        for (Device device : devices.values()) {
            Command command = device.getNextCommand();
            if (command == null)
                continue;

            JSONObject devObj = new JSONObject();
            devObj.put("name", device.getId());

            devObj.put("action", command.ordinal());
            devs.put(devObj);
        }

        return devs;
    }
}
