package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Dagenslunch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LUNCH_ID")
    private int lunchId;
    @Basic
    @Column(name = "DESCRIPTION")
    private String desc;
    @Basic
    @Column(name = "DATE")
    private Date date;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRICE")
    private int price;

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
        this.lunchId = lunchId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dagenslunch that = (Dagenslunch) o;
        return lunchId == that.lunchId && Objects.equals(desc, that.desc) && Objects.equals(date, that.date) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lunchId, desc, date, name);
    }

    @Override
    public String toString() {
        return name + "\n" +
                desc + "\n" +
                price + "\n";
    }
}
