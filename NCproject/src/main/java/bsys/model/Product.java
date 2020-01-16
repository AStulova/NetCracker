package bsys.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Proxy(lazy = false)
public class Product {
    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE,CascadeType.DETACH})
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

    public Product() {    }

    public Product(Tariff tariff, int value) {
        setTariff(tariff);
        Order order = new Order();
        order.setIdOrder(value);
        setOrder(order);
        setSms(value);
        setGb(value);
        setMinute(value);
        setSpeed(value);
    }

    public Product(Order order, Tariff tariff, int value) {
        setOrder(order);
        setTariff(tariff);
        setSms(value);
        setGb(value);
        setMinute(value);
        setSpeed(value);
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
}
