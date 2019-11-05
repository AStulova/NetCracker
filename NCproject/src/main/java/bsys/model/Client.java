package bsys.model;

public class Client {
    private int id_client;
    private String full_name;
    private String phone;
    private String email;
    //private String password;
    private int personal_account;
    private double money;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public int getPersonal_account() {
        return personal_account;
    }

    public void setPersonal_account(int personal_account) {
        this.personal_account = personal_account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", full_name=" + full_name + ' ' +
                ", phone=" + phone + ' ' +
                ", email=" + email + ' ' +
                ", personal_account=" + personal_account +
                ", money=" + money +
                '}';
    }
}
