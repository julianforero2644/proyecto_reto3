package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryInterface crud;
    // Traer toda la informacion
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }

    public Optional<Category> getCategory(int id){
        return crud.findById(id);
    }

    public Category save(Category category){
        return crud.save(category);
    }

    //DELETE
    public void delete(Category category){
        crud.delete(category);
    }

}
