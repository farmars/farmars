package gov.nasa.tepli4ka.server.plants_life_params;

/**
 * Created by nick on 28.05.16.
 */
public class CurrentParams {

    private int mAirTemperature;
    private int mGroundTemperature;
    private int mAirHumidity;
    private int mGroundHumidity;
    private int mOxygen;
    private static CurrentParams mCurrentParams;

    private CurrentParams() {}

    public static CurrentParams getInstance() {
        if (mCurrentParams == null) {
            mCurrentParams = new CurrentParams();
        }
        return mCurrentParams;
    }

    public synchronized int getAirHumidity() {
        return mAirHumidity;
    }

    public synchronized int getAirTemperature() {
        return mAirTemperature;
    }

    public synchronized int getGroundHumidity() {
        return mGroundHumidity;
    }

    public synchronized int getGroundTemperature() {
        return mGroundTemperature;
    }

    public synchronized int getOxygen() {
        return mOxygen;
    }

    public synchronized void setAirHumidity(int airHumidity) {
        mAirHumidity = airHumidity;
    }

    public synchronized void setAirTemperature(int airTemperature) {
        mAirTemperature = airTemperature;
    }

    public synchronized void setGroundHumidity(int groundHumidity) {
        mGroundHumidity = groundHumidity;
    }

    public synchronized void setGroundTemperature(int groundTemperature) {
        mGroundTemperature = groundTemperature;
    }

    public synchronized void setOxygen(int oxygen) {
        mOxygen = oxygen;
    }
}
