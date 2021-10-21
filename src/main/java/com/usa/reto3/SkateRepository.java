package com.usa.reto3;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SkateRepository {
    
    @Autowired
    private SkateInterface crud;
    // Traer toda la informacion
    public List<Skate> getAll(){
        return (List<Skate>) crud.findAll();
    }
    
    public Optional <Skate> getSkate(int id){
        return crud.findById(id);
    }
    
    public Skate save(Skate skate){
        return crud.save(skate);
    }
    //DELETE
    public void delete(Skate skate){
        crud.delete(skate);
    }
    

}
