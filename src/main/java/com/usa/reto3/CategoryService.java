package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository metodosCrud;

    public List<Category> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int id){
        return metodosCrud.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<Category> evt=metodosCrud.getCategory(category.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(category);
            }else{
                return category;
            }

        }
    }

    // Actualizar category
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=metodosCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return category;
    }

    public boolean delete(int id){

        Boolean aBoolean=getCategory(id).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
}
