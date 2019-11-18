package bsys.service;

import bsys.model.Client;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDAO clientDAO = new ClientDAOImpl();
    @Transactional
    public List<Client> allClients() {
        return clientDAO.allClients();
    }

    @Transactional
    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    @Transactional
    public void deleteClient(Client client) {
        clientDAO.deleteClient(client);
    }

    @Transactional
    public void editClient(Client client) {
        clientDAO.editClient(client);
    }

    @Transactional
    public Client getById(int idClient) {
        return clientDAO.getById(idClient);
    }
}