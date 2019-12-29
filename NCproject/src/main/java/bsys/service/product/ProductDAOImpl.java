package bsys.service.product;

import bsys.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> allProducts(final int idOrder) {
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery("select * from Product where id_order = :id")
                .addEntity(Product.class)
                .setParameter("id", idOrder).list();

        /* Criteria criteria = session.createCriteria(Product.class)
                .add(Restrictions.eq("id_order", idOrder));
        return criteria.list();
        */
        //return session.createQuery("from Product").list();
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

    @Override
    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public Product getById(int idProduct) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, idProduct);
    }
}
