package bsys.service.client;

import bsys.model.Client;
import bsys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientByEmail(String email, String password) {
        return clientRepository.getByEmailAndPassword(email, password);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public void editClient(String firstName, String lastName, String email, String phone, int id) {
        clientRepository.editClient(firstName, lastName, email, phone, id);
    }

    public Client getById(int idClient) {
        return clientRepository.getByIdClient(idClient);
    }
}