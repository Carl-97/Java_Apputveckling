package Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EMP_ID")
    private int empId;
    @Basic
    @Column(name = "FNAME")
    private String fname;
    @Basic
    @Column(name = "LNAME")
    private String lname;
    //@Basic
    //@Column(name = "USER_FK")
    //private Integer userFk;
    @ManyToOne
    @JoinColumn(name = "USER_FK", referencedColumnName = "USER_ID")
    private Users userByUsersFk;
    @OneToMany(mappedBy = "employeeByEmpFk")
    private Collection<EmployeeSchedule> employeeSchedulesByEmpId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
/*
    public Integer getUserFk() {
        return userFk;
    }

    public void setUserFk(Integer userFk) {
        this.userFk = userFk;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && Objects.equals(fname, employee.fname) && Objects.equals(lname, employee.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, fname, lname);
    }

    public Users getUserByUserFk() {
        return userByUsersFk;
    }

    public void setUserByUserFk(Users userByUsersFk) {
        this.userByUsersFk = userByUsersFk;
    }

    public Collection<EmployeeSchedule> getEmployeeSchedulesByEmpId() {
        return employeeSchedulesByEmpId;
    }

    public void setEmployeeSchedulesByEmpId(Collection<EmployeeSchedule> employeeSchedulesByEmpId) {
        this.employeeSchedulesByEmpId = employeeSchedulesByEmpId;
    }
}
