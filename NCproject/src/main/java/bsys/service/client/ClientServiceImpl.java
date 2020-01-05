package bsys.service.client;

import bsys.model.Client;
import bsys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
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