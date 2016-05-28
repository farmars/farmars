package gov.nasa.tepli4ka.plant;

/**
 * Created by nick on 28.05.16.
 *
 */
public class Plant {

    private String mName;
    public int mMinAirTemperature;
    public int mMaxAirTemperature;
    public int mMinGroundTemperature;
    public int mMaxGroundTemperature;
    public int mMinAirHumidity;
    public int mMaxAirHumidity;
    public int mMinGroundHumidity;
    public int mMaxGroundHumidity;
    public int mMaxOxygen;
    public int mMinOxygen;

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setMaxAirTemperature(int maxAirTemperature) {
        mMaxAirTemperature = maxAirTemperature;
    }

    public void setMaxAirHumidity(int maxAirHumidity) {
        mMaxAirHumidity = maxAirHumidity;
    }

    public void setMaxGroundHumidity(int maxGroundHumidity) {
        mMaxGroundHumidity = maxGroundHumidity;
    }

    public void setMaxGroundTemperature(int maxGroundTemperature) {
        mMaxGroundTemperature = maxGroundTemperature;
    }

    public void setMinAirTemperature(int minAirTemperature) {
        mMinAirTemperature = minAirTemperature;
    }

    public void setMinAirHumidity(int minAirHumidity) {
        mMinAirHumidity = minAirHumidity;
    }

    public void setMinGroundHumidity(int minGroundHumidity) {
        mMinGroundHumidity = minGroundHumidity;
    }

    public void setMinGroundTemperature(int minGroundTemperature) {
        mMinGroundTemperature = minGroundTemperature;
    }

    public int getMaxAirHumidity() {
        return mMaxAirHumidity;
    }

    public int getMaxAirTemperature() {
        return mMaxAirTemperature;
    }

    public int getMaxGroundHumidity() {
        return mMaxGroundHumidity;
    }

    public int getMaxGroundTemperature() {
        return mMaxGroundTemperature;
    }

    public int getMinAirHumidity() {
        return mMinAirHumidity;
    }

    public int getMinAirTemperature() {
        return mMinAirTemperature;
    }

    public int getMinGroundHumidity() {
        return mMinGroundHumidity;
    }

    public int getMinGroundTemperature() {
        return mMinGroundTemperature;
    }

    public int getMaxOxygen() {
        return mMaxOxygen;
    }

    public int getMinOxygen() {
        return mMinOxygen;
    }

    public void setMaxOxygen(int maxOxygen) {
        mMaxOxygen = maxOxygen;
    }

    public void setMinOxygen(int minOxygen) {
        mMinOxygen = minOxygen;
    }
}
