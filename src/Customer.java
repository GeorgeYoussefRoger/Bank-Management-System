public abstract class Customer {
    protected String customerId;
    protected String name;
    protected String phone;
    protected String email;

    protected Customer(String customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void updateContact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public abstract String getDetails();
}