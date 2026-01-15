public class CompanyCustomer extends Customer {
    private String registrationNumber;
    private String businessType;

    public CompanyCustomer(String id, String name, String phone, String email, String registrationNumber, String businessType) {
        super(id, name, phone, email);
        this.registrationNumber = registrationNumber;
        this.businessType = businessType;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getBusinessType() { return businessType; }

    @Override
    public String getDetails() {
        return "Company Customer [ID: " + getCustomerId() + ", Name: " + getName() + ", Phone: " + getPhone() + 
               ", Email: " + getEmail() + ", Registration Number: " + registrationNumber + ", Business Type: " + businessType + "]";
    }
}