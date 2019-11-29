package bsys.service.client;

import bsys.model.Client;
import java.util.List;

public interface ClientDAO {
    List<Client> allClients();
    void addClient(Client client);
    void deleteClient(Client client);
    void editClient(Client client);
    Client getById(int idClient);
}
