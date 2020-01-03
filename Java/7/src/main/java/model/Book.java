package model;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "storage")
    private int storage;

    @Column(name = "number")
    private int number;

    public Book() {    }

    public Book(String name, double price, int storage, int number) {
        this.name = name;
        this.price = price;
        this.storage = storage;
        this.number = number;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", storage=" + storage +
                ", number=" + number +
                '}';
    }
}
