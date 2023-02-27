package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@NamedQuery(
        name = "getTodayLunch",
        query = "SELECT e FROM TodaysLunch e WHERE e.date = CURRENT_DATE"
)
public class TodaysLunch {
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
    private Integer price;
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
        return lunchId == that.lunchId && Objects.equals(desc, that.desc) && Objects.equals(date, that.date) && Objects.equals(name, that.name)&& Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lunchId, desc, date, name,price);
    }

    @Override
    public String toString() {
        return name + "\n" +
                desc + "\n";
    }


}
