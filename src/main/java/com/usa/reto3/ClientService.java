package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository metodosCrud;

    public List<Client> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }

        }
    }


    public boolean delete(int id){

        Boolean aBoolean=getClient(id).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
}
