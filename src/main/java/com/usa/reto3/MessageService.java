package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository metodosCrud;

    public List<Message> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return metodosCrud.getMessage(idMessage);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }

        }
    }


    public boolean delete(int id){

        Boolean aBoolean=getMessage(id).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
}
