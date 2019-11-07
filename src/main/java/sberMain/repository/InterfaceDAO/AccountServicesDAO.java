package sberMain.repository.InterfaceDAO;

import sberMain.entity.Account;

import java.util.List;

public interface AccountServicesDAO {

    void save(Account account);
    List<Account> findAll();
    List<Account> findByInn(String  inn);
    double getAmountSumByInn(String inn) throws Exception;
}
