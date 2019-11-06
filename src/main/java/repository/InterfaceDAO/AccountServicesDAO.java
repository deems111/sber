package repository.InterfaceDAO;

import clients.entity.Account;

import java.util.List;

public interface AccountServicesDAO {

    void save(Account account);
    List<Account> findAll();
    List<Account> findByInn(long  inn);
    double getAmountSumByInn(long inn);
}
