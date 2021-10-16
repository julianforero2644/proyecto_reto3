package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService servicios;
    @GetMapping("/all")
    public List<Category> getCategory(){
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return servicios.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return servicios.save(category);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return servicios.delete(id);
    }


}