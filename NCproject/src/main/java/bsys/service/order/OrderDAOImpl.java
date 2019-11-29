package bsys.service.order;

import bsys.model.Order;
import bsys.service.order.OrderDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> allOrders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order").list();
    }

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
    }

    @Override
    public void deleteOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(order);
    }

    @Override
    public void editOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }

    @Override
    public Order getById(int idOrder) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, idOrder);
    }
}
