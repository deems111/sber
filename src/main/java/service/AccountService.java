package service;

import clients.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InterfaceDAO.AccountServicesDAO;

import java.util.List;

@Service
public class AccountService {

    private AccountServicesDAO accountServicesDAO;

    @Autowired
    public AccountService(AccountServicesDAO accountServicesDAO) {
        this.accountServicesDAO = accountServicesDAO;
    }

    public List<Account> getAll() {
        return accountServicesDAO.findAll();
    }

    public List<Account> getByInn(long inn) {
        return accountServicesDAO.findByInn(inn);
    }

    public double getSumByInn(long inn) {
        return accountServicesDAO.getAmountSumByInn(inn);
    }

}
