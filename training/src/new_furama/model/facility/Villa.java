package com.codegym.model.facility;

public class Villa extends Facility {
    private int poolArea;

    public Villa() {
    }

    public Villa(int poolArea) {
        this.poolArea = poolArea;
    }

    public Villa(String idFacility, String nameFacility, int feeRent, int poolArea) {
        super(idFacility, nameFacility, feeRent);
        this.poolArea = poolArea;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "poolArea=" + poolArea +
                '}';
    }

    @Override
    public String getLine() {
        return super.getLine() + "," + poolArea;
    }
}
