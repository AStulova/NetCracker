package bsys.service;

import bsys.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> allClients() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client").list();
    }

    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
    }

    @Override
    public void deleteClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(client);
    }

    @Override
    public void editClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }

    @Override
    public Client getById(int idClient) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, idClient);
    }
}