package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Connection")
public class Connection {
    @Id
    @Column(name = "id_connection")
    private int idConnection;

    @Column(name = "name_connection")
    private String nameConnection;

    @Column(name = "price_month")
    private double priceMonth;

    @Column(name = "price_connection")
    private double priceConnection;

    public int getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(int idConnection) {
        this.idConnection = idConnection;
    }

    public String getNameConnection() {
        return nameConnection;
    }

    public void setNameConnection(String nameConnection) {
        this.nameConnection = nameConnection;
    }

    public double getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(double priceMonth) {
        this.priceMonth = priceMonth;
    }

    public double getPriceConnection() {
        return priceConnection;
    }

    public void setPriceConnection(double priceConnection) {
        this.priceConnection = priceConnection;
    }
}
