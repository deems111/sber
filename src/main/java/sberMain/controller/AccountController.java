package sberMain.controller;

import org.springframework.web.bind.annotation.*;
import sberMain.AOP.ExecutionTimeAnno;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import sberMain.service.AccountService;


@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value="clients/{inn}", method = RequestMethod.GET)
    @ExecutionTimeAnno
    public double getSumByInn(@PathVariable String inn) throws Exception {
        return accountService.getSumByInn(inn);
    }

}
