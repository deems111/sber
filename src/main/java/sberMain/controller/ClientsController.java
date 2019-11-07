package sberMain.controller;

import sberMain.AOP.ExecutionTimeAnno;
import sberMain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sberMain.service.ClientService;


import java.util.List;


@RestController
public class ClientsController {

    private ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value="clients", method = RequestMethod.GET)
    @ExecutionTimeAnno
    public List<Client> list() {
        return clientService.getAll();
    }

    @ExecutionTimeAnno
    @RequestMapping(value="clients/{inn}", method = RequestMethod.GET)
    public Client findById(@PathVariable String inn) {
        return clientService.getByInn(inn);
    }


}
