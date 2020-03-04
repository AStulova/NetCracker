package bsys.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;

    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Incorrect first name!")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Incorrect last name!")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "(^$|[0-9]{11})", message = "Incorrect phone number!")
    @Column(name = "phone")
    private String phone;

    @Email(message = "Incorrect email!")
    @Column(name = "email")
    private String email;

    @Length(min = 8, max = 16, message = "Password must be between 8 and 16 characters.")
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