package gov.nasa.tepli4ka.server.plants_life_params;

import gov.nasa.tepli4ka.plant.Plant;

/**
 * Created by nick on 28.05.16.
 */
public class LifeParams {

    private int mMinAirTemperature = 20;
    private int mMaxAirTemperature = 30;
    private int mMinGroundTemperature = 10;
    private int mMaxGroundTemperature = 30;
    private int mMinAirHumidity = 10;
    private int mMaxAirHumidity = 50;
    private int mMinGroundHumidity = 5;
    private int mMaxGroundHumidity = 30;
    private int mMaxOxygen = 100;
    private int mMinOxygen = 50;
    private CurrentParams mCurrentParams;

    public void checkParams(Plant plant) {
        mCurrentParams = CurrentParams.getInstance();
        if (!checkAirHumidity(plant)) {
            // TODO: 28.05.16 Air humidity problems
        }
        if (!checkAirTemp(plant)) {
            // TODO: 28.05.16 Air temp problems
        }
        if (!checkGroundHumidity(plant)) {
            // TODO: 28.05.16 Ground humidity problems
        }
        if (!checkGroundTemp(plant)) {
            // TODO: 28.05.16 Ground temp problems
        }
        if (!checkOxygen(plant)) {
            // TODO: 28.05.16 Oxygen problems
        }

    }

    private boolean checkAirTemp(Plant plant) {
        int temp = mCurrentParams.getAirTemperature();
        return temp <= plant.mMaxAirTemperature && temp >= plant.mMinAirTemperature;
    }

    private boolean checkGroundTemp(Plant plant) {
        int temp = mCurrentParams.getGroundTemperature();
        return temp <= plant.mMaxGroundTemperature && temp >= plant.mMinGroundTemperature;
    }

    private boolean checkGroundHumidity(Plant plant) {
        int humidity = mCurrentParams.getGroundHumidity();
        return humidity <= plant.mMaxGroundHumidity && humidity >= plant.mMinGroundHumidity;
    }

    private boolean checkAirHumidity(Plant plant) {
        int humidity = mCurrentParams.getAirHumidity();
        return humidity <= plant.mMaxAirHumidity && humidity >= plant.mMinAirHumidity;
    }

    private boolean checkOxygen(Plant plant) {
        int oxygen = mCurrentParams.getOxygen();
        return oxygen <= plant.mMaxOxygen && oxygen >= plant.mMinOxygen;
    }
}
