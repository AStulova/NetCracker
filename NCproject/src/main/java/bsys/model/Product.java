package bsys.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order idOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tariff")
    private Tariff idTariff;

    @Column(name = "sms")
    private int sms;

    @Column(name = "gb")
    private int gb;

    @Column(name = "minute")
    private int minute;

    @Column(name = "speed")
    private int speed;

    @Column(name = "channel")
    private int channel;

    @Column(name = "addition")
    private String addition;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Order getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
    }

    public Tariff getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(Tariff idTariff) {
        this.idTariff = idTariff;
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

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }
}
