import java.time.LocalDate;

public class IndividualCustomer extends Customer {
    private LocalDate dob;

    public IndividualCustomer(String id, String name, LocalDate dob, String phone, String email) {
        super(id, name, phone, email);
        this.dob = dob;
    }

    public LocalDate getDob() { return dob; }

    @Override
    public String getDetails() {
        return "Individual Customer [ID: " + getCustomerId() + ", Name: " + getName() + ", Date of Birth: " + dob +
               ", Phone: " + getPhone() + ", Email: " + getEmail() + "]";
    }
}