package bsys.service.client;

import bsys.model.Client;
import java.util.List;

public interface ClientService {
    Client findClientByEmail(String email, String password);
    void addClient(Client client);
    void deleteClient(Client client);
    void editClient(String firstName, String lastName, String email, String phone, int id);
    Client getById(int idClient);
}
