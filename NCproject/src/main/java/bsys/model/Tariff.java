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
    private String typeTariff;

    @Column(name = "price")
    private double priceTariff;

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

    public String getTypeTariff() {
        return typeTariff;
    }

    public void setTypeTariff(String typeTariff) {
        this.typeTariff = typeTariff;
    }

    public double getPriceTariff() {
        return priceTariff;
    }

    public void setPriceTariff(double priceTariff) {
        this.priceTariff = priceTariff;
    }
}
