package com.usa.reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired
    private ReservationRepository metodosCrud;

    /**
     * metodo para obtener todos los datos de la tabla reservaciones
     * @return List de clase Reservacion
     */
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }

    /**
     * metodo para obtener dato de la tabla reservaciones por Id
     * @param idReservation
     * @return Optional de clase Reservacion
     */
    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }

    /**
     * metodo para registrar valores en la tabla reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
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

    /**
     * metodo para actualizar un dato de la tabla Reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    /**
     * metodo para borrar un dato de la tabla Reservaciones por Id
     * @param idReservation
     * @return boolean
     */
    public boolean delete(int idReservation){
        Boolean aBoolean=getReservation(idReservation).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }


    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= metodosCrud.ReservationStatus("completed");
        List<Reservation>cancelled= metodosCrud.ReservationStatus("cancelled");

        return new StatusReservas(completed.size(), cancelled.size() );
    }

    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();

        }
    }

    public List<ContadorClientes> reporteClientesServicio(){
        return metodosCrud.getClientesRepositorio();
    }


}
