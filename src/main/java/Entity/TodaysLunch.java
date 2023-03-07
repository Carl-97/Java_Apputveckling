package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name="getTodayLunch",
                query = "SELECT e FROM TodaysLunch e WHERE e.date = CURRENT_DATE"),
        @NamedQuery(name = "Lunch.all", query = "SELECT e FROM TodaysLunch e"),
        @NamedQuery(name = "Lunch.allOrderByDate", query = "SELECT e FROM TodaysLunch e ORDER BY e.date ASC")
}
)
public class TodaysLunch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LUNCH_ID")
    private int id;
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
    private Integer price;

    public TodaysLunch() {}

    public TodaysLunch(String desc, Date date, String name, Integer price) {
        this.desc = desc;
        this.date = date;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int lunchId) {
        this.id = lunchId;
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

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodaysLunch that = (TodaysLunch) o;
        return id == that.id && Objects.equals(desc, that.desc) && Objects.equals(date, that.date) && Objects.equals(name, that.name)&& Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, date, name,price);
    }

    @Override
    public String toString() {
        return name + "\n" +
                desc + "\n";
    }


}
