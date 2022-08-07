package com.codegym.model;

public class Booking {
    private String idBooking;
    private String idCustomer;
    private String idFacility;
    private String startTime;
    private String endTime;

    public Booking(String idBooking, String idCustomer, String idFacility, String startTime, String endTime) {
        this.idBooking = idBooking;
        this.idCustomer = idCustomer;
        this.idFacility = idFacility;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idFacility='" + idFacility + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public String getLine(){
        return idBooking + "," + idCustomer + "," + idFacility + "," + startTime + "," + endTime;
    }
}
