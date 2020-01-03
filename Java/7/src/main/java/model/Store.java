package model;

import javax.persistence.*;

@Entity
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStore;

    @Column(name = "name")
    private String name;

    @Column(name = "placement")
    private String placement;

    @Column(name = "commission")
    private double commission;

    public Store() {    }

    public Store(String name, String placement, double commission) {
        this.name = name;
        this.placement = placement;
        this.commission = commission;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Store{" +
                "idStore=" + idStore +
                ", name='" + name + '\'' +
                ", placement='" + placement + '\'' +
                ", commission=" + commission +
                '}';
    }
}
