package model;

import javax.persistence.*;

@Entity
@Table(name = "Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPurchase;

    @Column(name = "date")
    private String date;

    @Column(name = "id_store")
    private int idStore;

    @Column(name = "id_buyer")
    private int idBuyer;

    @Column(name = "id_book")
    private int idBook;

    @Column(name = "number")
    private int number;

    @Column(name = "total")
    private double total;

    public Purchase() { }

    public Purchase(String date, int idStore, int idBuyer, int idBook, int number, double total) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
