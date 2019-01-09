package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PointDTO {
    private double lat;
    private double lon;



    private double alt;
    private int speed;
   // private String autoId;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

//    public String getAutoId() {
//        return autoId;
//    }

//   // public void setAutoId(String autoId) {
//        this.autoId = autoId;
//    }

    public double getAlt() {
        return alt;
    }

    public int getSpeed() {
        return speed;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

//    @Override
//    public String toString() {
//        return "PointDTO{" +
//                "lat=" + lat +
//                ", lon=" + lon +
//                ", autoId='" + autoId + '\'' +
//                '}';
//    }
}
