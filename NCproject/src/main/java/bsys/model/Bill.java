package bsys.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @Column(name = "id_bill")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBill;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "date_bill")
    private Date dateBill;

    @Column(name = "total")
    private double total;

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date dateBill) {
        this.dateBill = dateBill;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
