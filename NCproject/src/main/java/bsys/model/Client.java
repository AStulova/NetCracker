package bsys.model;

public class Client {
    private int idClient;
    private String fullName;
    private String phone;
    private String email;
    //private String password;
    private int personalAccount;
    private double balance;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String  getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(int personalAccount) {
        this.personalAccount = personalAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double money) {
        this.balance = money;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + idClient +
                ", full_name=" + fullName + ' ' +
                ", phone=" + phone + ' ' +
                ", email=" + email + ' ' +
                ", personal_account=" + personalAccount +
                ", money=" + balance +
                '}';
    }
}
