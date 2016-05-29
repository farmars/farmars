package gov.nasa.farmars.farm;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import gov.nasa.farmars.controller.Controller;
import gov.nasa.farmars.plant.Plant;

public class Farm {

    private Map<String, Controller> controllers;
    private Map<String, Plant> plants;

    private static Farm instance;

    public static synchronized Farm getInstance() {
        if (instance == null) {
            instance = new Farm();
        }
        return instance;
    }

    private Farm() {
        controllers = new HashMap<String, Controller>();
        plants = new HashMap<String, Plant>();
    }

    public void registerController(Controller controller) {
        controllers.put(controller.getId(), controller);
    }

    public void unregisterController(Controller controller) {
        controllers.remove(controller.getId());
    }

    public void registerPlant(Plant plant) {
        plants.put(plant.getId(), plant);
    }

    public void unregisterPlant(Plant plant) {
        plants.remove(plant.getId());
    }

    public JSONObject getControllerJSON() {
        JSONObject farmControllers = new JSONObject();
        for (Controller c : controllers.values()) {
            JSONArray devicesArray = c.getDevicesJSON();
            if (devicesArray.length() == 0)
                continue;
            farmControllers.put(c.getId(), devicesArray);
        }

        return farmControllers;
    }

}

