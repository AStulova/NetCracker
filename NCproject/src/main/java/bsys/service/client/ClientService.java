package bsys.service.client;

import bsys.model.Client;

import java.util.List;

public interface ClientService {
    Client findClientByEmail(String email);
    List<Client> findAll();
    void addClient(Client client);
    void deleteClient(Client client);
    void editClient(Client client);
    Client getById(int idClient);
    Client getAuthClient();
}
