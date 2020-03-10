package bsys.service.client;

import bsys.model.Client;
import bsys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public void addClient(Client client) {
        Client curClient = getByEmail(client.getEmail());
        if (client.getIdClient() == 0 && curClient != null) {
            throw new IllegalStateException("You already have an account!");
        }
        else {
            client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
            editClient(client);
        }
    }

    @Override
    @Transactional
    public void editClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> findAllUsers() {
        return clientRepository.findAll(Sort.by(Sort.Direction.ASC, "idClient"));
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAllByRoleOrderByIdClient("USER");
    }

    @Override
    @Transactional
    public Client getById(int idClient) {
        return clientRepository.getOne(idClient);
    }

    @Override
    public Client getByEmail(String email) {
        return clientRepository.getByEmail(email);
    }

    @Override
    public Client getAuthClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return clientRepository.getByEmail(authentication.getName());
    }
}