package sberMain.controller;

import org.springframework.web.bind.annotation.*;
import sberMain.AOP.ExecutionTimeAnno;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import sberMain.service.AccountService;


@RestController
@RequestMapping("amount")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/{inn}", method = RequestMethod.GET)
    @ResponseBody
    @ExecutionTimeAnno
    public double getSumByInn(@PathVariable long inn) {
        return accountService.getSumByInn(inn);
    }


}
