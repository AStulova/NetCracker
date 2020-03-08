package bsys.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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

    @Column(name = "type")
    private String typeTariff;

    @NotNull(message = "Enter price!")
    @DecimalMin(value = "0", message = "Price must be positive!")
    @Digits(integer = 4, fraction = 2, message = "Incorrect price!")
    //@NumberFormat(style = NumberFormat.Style.NUMBER)
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
