package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @Column(name = "id_bill")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBill;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client idClient;

    @Column(name = "date_bill")
    private String dateBill;

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public String getDateBill() {
        return dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }
}
