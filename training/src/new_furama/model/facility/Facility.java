package com.codegym.model.facility;

public abstract class  Facility {
   private String idFacility;
   private String nameFacility;
   private int rentPrice;

    public Facility() {
    }

    public Facility(String idFacility, String nameFacility, int rentPrice) {
        this.idFacility = idFacility;
        this.nameFacility = nameFacility;
        this.rentPrice = rentPrice;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        return
                "idFacility='" + idFacility + '\'' +
                ", nameFacility='" + nameFacility + '\'' +
                ", rentPrice=" + rentPrice +
                '}';
    }
    public String getLine() {
        return idFacility + "," + nameFacility + "," + rentPrice;
    }
}
