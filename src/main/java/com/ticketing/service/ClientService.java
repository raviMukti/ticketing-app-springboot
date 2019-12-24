package com.ticketing.service;

import com.ticketing.entity.Client;
import com.ticketing.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("clientService")
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

//    Save client
    public Client insertClient(Client client){
        return clientRepository.save(client);
    }

//    Return all client
    public List<Client> findAll(){
        return clientRepository.findAllClient();
    }

//    return client find by username
    public List<Client> findByName(String name){
        return clientRepository.findByName(name);
    }

//    Delete client
    public boolean deleteById(String id){
        clientRepository.deleteById(id);
        return true;
    }
}
