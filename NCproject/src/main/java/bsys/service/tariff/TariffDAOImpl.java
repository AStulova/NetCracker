package bsys.service.tariff;

import bsys.model.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TariffDAOImpl implements TariffDAO {
   private SessionFactory sessionFactory;

   @Autowired
   public void setSessionFactory(SessionFactory sessionFactory) {
       this.sessionFactory = sessionFactory;
   }

    @Override
    public List<Tariff> allTariffs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Tariff").list();
    }

    @Override
    public void addTariff(Tariff tariff) {
       Session session = sessionFactory.getCurrentSession();
       session.persist(tariff);
    }

    @Override
    public void deleteTariff(Tariff tariff) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tariff);
    }

    @Override
    public Tariff getById(int idTariff) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tariff.class, idTariff);
    }
}
