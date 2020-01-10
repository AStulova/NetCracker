package app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPurchase;
    private Date date;
    private int idStore;
    private int idBuyer;
    private int idBook;
    private int number;
    private double total;

    public Purchase() { }

    public Purchase(Date date, int idStore, int idBuyer, int idBook, int number, double total) {
        this.date = date;
        this.idStore = idStore;
        this.idBuyer = idBuyer;
        this.idBook = idBook;
        this.number = number;
        this.total = total;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
