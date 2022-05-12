package com.wehightech.parking.model;

public class Parking {

    private String id;
    private String name;
    private int availablePlaceCount;
    private int totalPlaceCount;
    private String status;
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailablePlaceCount() {
        return availablePlaceCount;
    }

    public void setAvailablePlaceCount(int availablePlaceCount) {
        this.availablePlaceCount = availablePlaceCount;
    }

    public int getTotalPlaceCount() {
        return totalPlaceCount;
    }

    public void setTotalPlaceCount(int totalPlaceCount) {
        this.totalPlaceCount = totalPlaceCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
