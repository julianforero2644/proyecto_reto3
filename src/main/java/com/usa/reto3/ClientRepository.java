package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientInterface crud;
    // Traer toda la informacion
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getClient(int id){
        return crud.findById(id);
    }

    public Client save(Client client){
        return crud.save(client);
    }

    //DELETE
    public void delete(Client client){
        crud.delete(client);
    }

}
