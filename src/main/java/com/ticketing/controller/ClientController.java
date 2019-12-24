package com.ticketing.controller;

import com.ticketing.dto.ClientDTO;
import com.ticketing.entity.Client;
import com.ticketing.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

//    endpoint untuk create client
    @RequestMapping(method = RequestMethod.POST)
    public Client inserClient(@RequestBody Client client){
        return clientService.insertClient(client);
    }

//    endpoint untuk get client all
    @RequestMapping(method = RequestMethod.GET)
    public List<Client> findAll(){
        return clientService.findAll();
    }

//    endpoint untuk delete client by id
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteById(@PathVariable String id){
        return clientService.deleteById(id);
    }

//    endpoint untuk find by name
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public List<Client> findByName(@RequestBody @NotNull ClientDTO clientDTO){
        return clientService.findByName(clientDTO.getSearchKey());
    }

}
