package bsys.service.client;

import bsys.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAllClients(String role);
    void addClient(Client client);
    void editClient(Client client);
    Client getById(int idClient);
    Client getAuthClient();
}
