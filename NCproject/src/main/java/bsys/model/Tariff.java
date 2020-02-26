package bsys.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Entity
@Table(name = "Tariff")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tariff")
    private int idTariff;

    @Pattern(regexp = "^[a-zA-Z0-9]{1,255}$", message = "Incorrect tariff name!")
    @Column(name = "name_tariff")
    private String nameTariff;

    //@Pattern(regexp = "^[a-zA-Z0-9]{1,255}$", message = "Incorrect tariff type!")
    @Column(name = "type")
    private String typeTariff;

    @DecimalMin(value = "0.0", message = "Incorrect price!") // ?
    @Digits(integer = 4, fraction = 2, message = "Incorrect price!")
    @Column(name = "price")
    private BigDecimal priceTariff;

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

    public BigDecimal getPriceTariff() {
        return priceTariff;
    }

    public void setPriceTariff(BigDecimal priceTariff) {
        this.priceTariff = priceTariff;
    }
}
