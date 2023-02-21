package Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@NamedQuery(
        name = "getLunch",
        query = ""
)
public class Dagenslunch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PK")
    private int pk;
    @Basic
    @Column(name = "desc")
    private String desc;
    @Basic
    @Column(name = "DATE")
    private Date date;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dagenslunch that = (Dagenslunch) o;
        return pk == that.pk && Objects.equals(desc, that.desc) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, desc, date);
    }
}
