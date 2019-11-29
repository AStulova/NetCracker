package bsys.service.account;

import bsys.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Account> allAccounts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Account ").list();
    }

    @Override
    public void addAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(account);
    }

    @Override
    public void deleteAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
    }

    @Override
    public void editAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }

    @Override
    public Account getById(int idAccount) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, idAccount);
    }
}
