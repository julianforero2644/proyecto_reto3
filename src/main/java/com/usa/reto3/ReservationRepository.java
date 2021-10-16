package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationInterface crud;
    // Traer toda la informacion
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }

    //DELETE
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }

}
