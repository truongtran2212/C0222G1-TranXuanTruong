package new_furama.model.facility;

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
