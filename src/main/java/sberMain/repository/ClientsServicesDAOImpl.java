package sberMain.repository;

import sberMain.entity.Client;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import sberMain.repository.InterfaceDAO.ClientsServicesDAO;

import java.util.List;

@Repository
public class ClientsServicesDAOImpl implements ClientsServicesDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public List<Client> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Client").list();
    }

    @Override
    public Client findByInn(long inn) {
        Query query =  sessionFactory.getCurrentSession()
                .createQuery("FROM Client WHERE inn = :inn");
        query.setParameter("inn", inn);
        return (Client) query.uniqueResult();
    }

}
