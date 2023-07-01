package Sessoin_6;

public class Clint {
    private String name;
    private String address;
    private String phoneNumber;
    private BankAccount account;

    public Clint(String name, String address, String phoneNumber, BankAccount account) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}
