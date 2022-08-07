package com.codegym.model.facility;

public class House extends Facility{
    public House() {
    }

    public House(String idFacility, String nameFacility, int feeRent) {
        super(idFacility, nameFacility, feeRent);
    }

    @Override
    public String toString() {
        return "House{ " + super.toString();
    }
}
