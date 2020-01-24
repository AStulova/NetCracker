package bsys.service.client;

import bsys.model.Client;
import bsys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    private void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.getByEmail(email);
    }

    public void addClient(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        client.setRole("USER");
        clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void editClient(Client client) {
        clientRepository.save(client);
        /*int id = getAuthClient().getIdClient();
        if (!client.getFirstName().equals("")) {
            clientRepository.editFirstName(client.getFirstName(), id);
        }
        if (!client.getLastName().equals("")) {
            clientRepository.editLastName(client.getLastName(), id);
        }
        if (!client.getPhone().equals("")) {
            clientRepository.editPhone(client.getPhone(), id);
        }*/
    }

    @Override
    public Client getById(int idClient) {
        return clientRepository.getOne(idClient);
    }

    @Override
    public Client getAuthClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return clientRepository.getByEmail(authentication.getName());
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

}