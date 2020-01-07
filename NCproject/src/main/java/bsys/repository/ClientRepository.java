package bsys.repository;

import bsys.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getByIdClient(int idClient);

    Client getByEmail(String email);

    @Modifying
    @Query("update Client c set c.firstName = ?1, c.lastName = ?2, c.email = ?3, c.phone = ?4 where c.idClient = ?5")
    void editClient(String firstName, String lastName, String email, String phone, int id);
}
