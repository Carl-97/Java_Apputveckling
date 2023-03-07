package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Dinnertable.all", query = "SELECT e FROM Dinnertable e")
}
)
public class Dinnertable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TABLE_ID")
    private int id;
    @Basic
    @Column(name = "TABLESIZE")
    private Integer tablesize;

    public int getId() {
        return id;
    }

    public void setId(int tableId) {
        this.id = tableId;
    }

    public Integer getTablesize() {
        return tablesize;
    }

    public void setTablesize(Integer tablesize) {
        this.tablesize = tablesize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinnertable that = (Dinnertable) o;
        return id == that.id && Objects.equals(tablesize, that.tablesize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tablesize);
    }

    @Override
    public String toString() {
        return "Dinnertable{" +
                "tableId=" + id +
                ", tablesize=" + tablesize +
                '}';
    }
}
