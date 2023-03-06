package Controllers;

import Entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.Date;

@Named
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class bookingInfo {

    private String name;
    private Integer sizeofgroup;
    private Date date;
    private String time;
    private String phone;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @PersistenceContext(name = "default")
    private EntityManager em;

    public void submit() {
        Customer customer = new Customer(name, sizeofgroup, date, time, phone);
        em.persist(customer);
    }

}
