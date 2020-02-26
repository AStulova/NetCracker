package bsys.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_tariff")
    private Tariff tariff;

    @Column(name = "sms")
    private int sms;

    @Column(name = "gb")
    private int gb;

    @Column(name = "minute")
    private int minute;

    @Column(name = "speed")
    private int speed;

    @Column(name = "price")
    private BigDecimal price;

    public Product() {    }

    public Product(Tariff tariff, Client client) {
        setTariff(tariff);
        Order order = new Order();
        order.setIdOrder(0);
        order.setClient(client);
        setOrder(order);
    }

    public Product(Order order, Tariff tariff) {
        setOrder(order);
        setTariff(tariff);
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
