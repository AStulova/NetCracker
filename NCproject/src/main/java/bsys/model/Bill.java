package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @Column(name = "id_bill")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBill;

    @Column(name = "id_client")
    private int idClient;

    @Column(name = "date_bill")
    private double dateBill;

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getDateBill() {
        return dateBill;
    }

    public void setDateBill(double dateBill) {
        this.dateBill = dateBill;
    }
}
