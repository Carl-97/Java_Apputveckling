package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
//@Table(name = "DINNERTABLE", schema = "APP", catalog = "")
@NamedQuery(
        name = "",
        query = ""
)
public class Dinnertable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TABLE_ID")
    private int tableId;
    @Basic
    @Column(name = "TABLESIZE")
    private Integer tablesize;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
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
        return tableId == that.tableId && Objects.equals(tablesize, that.tablesize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, tablesize);
    }

    @Override
    public String toString() {
        return "DinnertableEntity{" +
                "tableId=" + tableId +
                ", tablesize=" + tablesize +
                '}';
    }
}
