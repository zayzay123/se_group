package fcu.sep.fcushop.model;

public class User {

    private int id;

    private String name;

    private String account;

    private String password;

    private String email;

    private String phoneNumber;

    private String orderNumber;

    public User(int id, String name, String account, String password, String email, String phoneNumber, String orderNumber) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderNumber = orderNumber;
    }

    public User() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getOrderNumber() { return orderNumber; }

    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
}
