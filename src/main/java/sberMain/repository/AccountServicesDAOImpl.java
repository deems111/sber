package sberMain.repository;

import sberMain.entity.Account;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sberMain.repository.InterfaceDAO.AccountServicesDAO;

import java.util.List;

@Repository
public class AccountServicesDAOImpl implements AccountServicesDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public AccountServicesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    @Override
    public List<Account> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Account").list();
    }

    @Override
    public List<Account> findByInn(long inn) {
        Query query =  sessionFactory.getCurrentSession()
                .createQuery("FROM Client WHERE inn = :inn");
        query.setParameter("inn", inn);
        return   query.list();
    }

    @Override
    public double getAmountSumByInn(long inn) {
        double sum = 0;
        List<Account> accounts =  findByInn(inn);
        for (Account account: accounts) {
            sum+=account.getBalance();
        }
        return sum;
    }
}
