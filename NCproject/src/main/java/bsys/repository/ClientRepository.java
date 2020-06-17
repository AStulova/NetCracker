package bsys.repository;

import bsys.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getByEmail(String email);

    List<Client> findClientsByIdClientIsNotOrderByIdClient(int idClient);

    List<Client> findAllByRoleOrderByIdClient(String role);
}
