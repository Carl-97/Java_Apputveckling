package Controllers;

import Entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Named
@RequestScoped
public class bookingInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;



    public void createNewCustomer(String name, Integer sizeofgroup, LocalDate date, LocalTime time, String phone) {
        Customer customer = new Customer(name, sizeofgroup, date, time, phone);


        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

    }



}
