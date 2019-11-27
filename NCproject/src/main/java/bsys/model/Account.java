package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccount;

    @Column(name = "id_client")
    private int idClient;

    @Column(name = "total")
    private double totalAccount;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(double totalAccount) {
        this.totalAccount = totalAccount;
    }
}
