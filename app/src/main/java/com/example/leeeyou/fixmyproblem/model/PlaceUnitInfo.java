package com.example.leeeyou.fixmyproblem.model;

import java.io.Serializable;

/**
 * 场地对象
 * <p/>
 * Created by Evan-st on 16/6/28.
 */
public class PlaceUnitInfo implements Serializable {

    private int placeUnitId;
    private int placeId;
    private String name;
    private String address;
    private String lat;
    private String lng;
    private String unitName;
    private int districtId;
    private int cityId;
    private int isChoose;

    public int isChoose() {
        return isChoose;
    }

    public void setChoose(int choose) {
        isChoose = choose;
    }

    public int getPlaceUnitId() {
        return placeUnitId;
    }

    public void setPlaceUnitId(int placeUnitId) {
        this.placeUnitId = placeUnitId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
