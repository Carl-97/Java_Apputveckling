package Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.all", query = "SELECT e FROM Customer e")
})
public class Customer implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "SIZEOFGROUP")
    private Integer sizeofgroup;
    @Basic
    @Column(name = "DATE")
    private Date date;
    @Basic
    @Column(name = "TIME")
    private Time time;
    @Basic
    @Column(name = "PHONE")
    private String phone;

    public Customer() {}

    public Customer(String name, Integer sizeofgroup, Date date, Time time, String phone) {
        this.name = name;
        this.sizeofgroup = sizeofgroup;
        this.date = date;
        this.time = time;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(name, customer.name) && Objects.equals(sizeofgroup, customer.sizeofgroup) && Objects.equals(date, customer.date) && Objects.equals(time, customer.time) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, sizeofgroup, date, time, phone);
    }
}
