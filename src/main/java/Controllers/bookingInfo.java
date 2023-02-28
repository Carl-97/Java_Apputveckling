package Controllers;

import Entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Named
@RequestScoped
public class bookingInfo {
    private String name;
    private Integer sizeofgroup;
    private Date date;
    private Time time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
        this.message = "Tack för din reservation !";
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


}
