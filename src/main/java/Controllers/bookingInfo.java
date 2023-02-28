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

    @PersistenceContext(name = "default")
    private EntityManager em;

    public List<Customer> getAll() {
        return em.createNamedQuery("Customer.all", Customer.class).getResultList();
    }

    public void createNewCustomer(String name, Integer sizeofgroup, Date date, Time time, String phone) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setSizeofgroup(sizeofgroup);
        customer.setDate(date);
        customer.setTime(time);
        customer.setPhone(phone);

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }
}
