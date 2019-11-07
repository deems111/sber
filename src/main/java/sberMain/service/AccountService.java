package sberMain.service;

import sberMain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sberMain.repository.InterfaceDAO.AccountServicesDAO;

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

    public List<Account> getByInn(String inn) {
        return accountServicesDAO.findByInn(inn);
    }

    public double getSumByInn(String inn) throws Exception {
        return accountServicesDAO.getAmountSumByInn(inn);
    }

}
