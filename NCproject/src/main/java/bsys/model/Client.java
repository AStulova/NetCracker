package bsys.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;

    @NotBlank(message = "First name must not be empty.")
    @Length(max = 255, message = "Text is too long.")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "First name must begin with a capital letter.")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name must not be empty.")
    @Length(max = 255, message = "Text is too long.")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name must begin with a capital letter.")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Phone must not be empty.")
    @Pattern(regexp = "(^$|[0-9]{11})", message = "Phone number is not correct.")
    @Column(name = "phone")
    private String phone;

    @Email(message = "Email is not correct.")
    @NotBlank(message = "Email must not be empty.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password must not be empty.")
    @Length(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private double balance;

    @Column(name = "role")
    private String role;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}