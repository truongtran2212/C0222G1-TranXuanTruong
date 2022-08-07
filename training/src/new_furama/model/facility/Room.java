package com.codegym.model.facility;

import javax.security.auth.login.FailedLoginException;

public class Room extends Facility {
    public Room() {
    }

    public Room(String idFacility, String nameFacility, int rentPrice) {
        super(idFacility, nameFacility, rentPrice);
    }

    @Override
    public String toString() {
        return "Room{ " + super.toString();
    }
}
