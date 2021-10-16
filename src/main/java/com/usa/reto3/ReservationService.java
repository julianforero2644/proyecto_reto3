package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository metodosCrud;

    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> evt=metodosCrud.getReservation(reservation.getIdReservation());
            if(evt.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }

        }
    }


    public boolean delete(int id){

        Boolean aBoolean=getReservation(id).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
}
