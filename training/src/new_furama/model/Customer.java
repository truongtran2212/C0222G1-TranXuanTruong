package new_furama.model;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private String dateOfBirth;
    private String booking ;

    public Customer() {
    }

    public Customer(String idCustomer, String nameCustomer, String dateOfBirth, String booking) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.booking = booking;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", booking=" + booking +
                '}';
    }
    public String getLine(){
        return idCustomer + "," +
                nameCustomer + "," +
                dateOfBirth + "," +
                booking;
    }
}
