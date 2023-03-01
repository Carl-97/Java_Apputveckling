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
    private String name;
    private Integer sizeofgroup;
    private LocalDate date;
    private LocalTime time;
    private String phone;
    private String message;

    @PersistenceContext(name = "default")
    private EntityManager em;

    public List<Customer> getAll() {
        return em.createNamedQuery("Customer.all", Customer.class).getResultList();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSizeofgroup() {
        return sizeofgroup;
    }

    public void setSizeofgroup(Integer sizeofgroup) {
        this.sizeofgroup = sizeofgroup;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void createNewCustomer() {
        Customer customer = new Customer(name, sizeofgroup, date, time, phone);


        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        // clear the form data after saving the customer data
        this.name = null;
        this.sizeofgroup = null;
        this.date = null;
        this.time = null;
        this.phone = null;
    }
    public String submit() {
        createNewCustomer();
        setMessage ("Tack för din reservation !");
        clearFields();
        return null; // stay on the same page
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void clearFields() {
        this.name = null;
        this.sizeofgroup = null;
        this.date = null;
        this.time = null;
        this.phone = null;
    }
    @FacesConverter(value = "localTimeConverter")
    public class LocalTimeConverter extends DateTimeConverter {

        public LocalTimeConverter() {
            setPattern("HH:mm");
        }

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern());
                LocalTime time = LocalTime.parse(value, formatter);
                return time;
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid time format", e);
            }
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
            if (value instanceof LocalTime) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern());
                return ((LocalTime) value).format(formatter);
            } else {
                throw new IllegalArgumentException("Invalid object type");
            }
        }
    }


}
