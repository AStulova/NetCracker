package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Tariff")
public class Tariff {
    @Id
    @Column(name = "id_tariff")
    private int idTariff;

    @Column(name = "name_tariff")
    private String nameTariff;

    @Column(name = "type")
    private double type;

    @Column(name = "price")
    private double price;

    public int getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(int idTariff) {
        this.idTariff = idTariff;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public double getType() {
        return type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
