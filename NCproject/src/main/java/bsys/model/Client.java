package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @Column(name = "id_client")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idClient;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "personal_account")
    private int personalAccount;

    @Column(name = "balance")
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

    public String getPhone() {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}