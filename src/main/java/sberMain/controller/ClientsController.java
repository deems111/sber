package sberMain.controller;

import sberMain.AOP.ExecutionTimeAnno;
import sberMain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sberMain.service.ClientService;


import java.util.List;


@RestController
@RequestMapping("clients")
public class ClientsController {

    private ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ExecutionTimeAnno
    public List<Client> list() {
        return clientService.getAll();
    }

    @RequestMapping(value="/{inn}", method = RequestMethod.GET)
    @ResponseBody
    @ExecutionTimeAnno
    public Client findById(@PathVariable long inn) {
        return clientService.getByInn(inn);
    }


}
