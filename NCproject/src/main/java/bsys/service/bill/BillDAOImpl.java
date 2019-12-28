package bsys.service.bill;

import bsys.model.Bill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BillDAOImpl implements BillDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Bill> allBills() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Bill ").list();
    }

    @Override
    public void addBill(Bill bill) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(bill);
    }

    @Override
    public void deleteBill(Bill bill) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(bill);
    }

    @Override
    public void editBill(Bill bill) {
        Session session = sessionFactory.getCurrentSession();
        session.update(bill);
    }

    @Override
    public Bill getById(int idBill) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Bill.class, idBill);
    }
}
