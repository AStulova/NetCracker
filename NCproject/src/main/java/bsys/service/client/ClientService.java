package bsys.service.client;

import bsys.model.Client;

public interface ClientService {
    Client findClientByEmail(String email);
    void addClient(Client client);
    void deleteClient(Client client);
    void editClient(String firstName, String lastName, String email, String phone, int id);
    Client getById(int idClient);
}
