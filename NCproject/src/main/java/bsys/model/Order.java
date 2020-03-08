package bsys.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_order")
    private Date dateOrder;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_cancel")
    private Date dateCancel;

    @NotNull(message = "This field is required!")
    @Digits(integer = 3, fraction = 0, message = "Discount must be integer!")
    //@Range(min = 0, max = 100, message = "Discount must be between 0 and 100!")
    @Column(name = "discount")
    private Integer discount;

    @Column(name = "price")
    private BigDecimal priceOrder;

    @Column(name = "status")
    private int statusOrder;
    /*
        0 - Saved
        1 - Active
        2 - Canceled
     */

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateCancel() {
        return dateCancel;
    }

    public void setDateCancel(Date dateCancel) {
        this.dateCancel = dateCancel;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(BigDecimal priceOrder) {
        this.priceOrder = priceOrder;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }
}
