package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageInterface crud;
    // Traer toda la informacion
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }

    public Optional<Message> getMessage(int id){
        return crud.findById(id);
    }

    public Message save(Message message){
        return crud.save(message);
    }

    //DELETE
    public void delete(Message message){
        crud.delete(message);
    }

}
