package bsys.service;

import bsys.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@Repository
public class ClientImp implements ClientService {
    private static final AtomicInteger AUTO_ID = new AtomicInteger();
    private static Map<Integer, Client> clients = new HashMap<>();

    static {
        Client client1 = new Client();
        client1 = new Client();
        client1.setIdClient(5438);
        client1.setFullName("Courteney Cox");
        client1.setPhone("+79106845169");
        client1.setEmail("CourteneyCox@gmail.com");
        client1.setPersonalAccount(2568452);
        client1.setBalance(578.47);
        clients.put(client1.getIdClient(), client1);
    }

    @Override
    public List<Client> allClients() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public void addClient(Client client) {
        client.setIdClient(AUTO_ID.getAndIncrement());
        clients.put(client.getIdClient(), client);
    }

    @Override
    public void deleteClient(Client client) {
        clients.remove(client.getIdClient());
    }

    @Override
    public void editClient(Client client) {
        clients.put(client.getIdClient(), client);
    }

    @Override
    public Client getById(int idClient) {
        return clients.get(idClient);
    }
}