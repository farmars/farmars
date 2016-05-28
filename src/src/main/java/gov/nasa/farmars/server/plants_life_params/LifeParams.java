package gov.nasa.farmars.server.plants_life_params;

import java.util.Calendar;
import gov.nasa.farmars.plant.Plant;
import gov.nasa.farmars.server.send.SendToServer;

/**
 * Created by nick on 28.05.16.
 */
public class LifeParams {

    private CurrentParams mCurrentParams;

    public void checkParams(Plant plant) {
        mCurrentParams = CurrentParams.getInstance();
        boolean mAirHumidity = checkAirHumidity(plant);
        boolean mAirTemp = checkAirTemp(plant);
        boolean mGroundHumidity = checkGroundHumidity(plant);
        boolean mGroundTemp = checkGroundTemp(plant);
        boolean mOxygen = checkOxygen(plant);
        boolean mLight = checkLight();

        SendToServer mSendToServer = new SendToServer();
        mSendToServer.setParams(mAirTemp, mAirHumidity, mGroundTemp, mGroundHumidity, mOxygen, mLight);

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

    private boolean checkLight() {
        Calendar mCalendar = Calendar.getInstance();
        int time = mCalendar.get(Calendar.HOUR_OF_DAY);
        return time <= 21 && time >= 5;
    }
}
