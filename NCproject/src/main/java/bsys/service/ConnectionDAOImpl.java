package bsys.service;

import bsys.model.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO {
   private SessionFactory sessionFactory;

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
       this.sessionFactory = sessionFactory;
   }

    @Override
    public List<Connection> allConnections() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Connection").list();
    }

    @Override
    public void addConnection(Connection connection) {
       Session session = sessionFactory.getCurrentSession();
       session.persist(connection);
    }

    @Override
    public void deleteConnection(Connection connection) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(connection);
    }

    @Override
    public Connection getById(int idConnection) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Connection.class, idConnection);
    }
}
