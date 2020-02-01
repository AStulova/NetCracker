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

    public void addClient(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        client.setRole("USER");
        clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> findAll(String role) {
        return clientRepository.findAllByRole(role);
    }

    @Override
    @Transactional
    public void editClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional
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