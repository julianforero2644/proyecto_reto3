package com.usa.reto3;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkateService {
    
    @Autowired
    private SkateRepository metodosCrud;
    
    public List<Skate> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Skate> getSkate(int id){
        return metodosCrud.getSkate(id);
    }
    
    public Skate save(Skate skate){
         if(skate.getId()==null){
            return metodosCrud.save(skate);
        }else{
            Optional<Skate> evt=metodosCrud.getSkate(skate.getId());
            if(evt.isEmpty()){
            return metodosCrud.save(skate);
            }else{
                return skate;
            }
        
        }
    }


    public boolean delete(int id){

        Boolean aBoolean=getSkate(id).map(skate -> {
            metodosCrud.delete(skate);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }

}
