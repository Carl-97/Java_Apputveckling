package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_SCHEDULE")
public class EmployeeSchedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EMPLOYEESCHEDULE_ID")
    private int employeescheduleId;
    @ManyToOne
    @JoinColumn(name = "EMP_FK", referencedColumnName = "EMP_ID")
    private Employee employeeByEmpFk;
    @ManyToOne
    @JoinColumn(name = "SCHEDULE_FK", referencedColumnName = "SCHEDULE_ID")
    private Schedule scheduleByScheduleFk;

    public int getEmployeescheduleId() {
        return employeescheduleId;
    }

    public void setEmployeescheduleId(int employeescheduleId) {
        this.employeescheduleId = employeescheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSchedule that = (EmployeeSchedule) o;
        return employeescheduleId == that.employeescheduleId && Objects.equals(employeeByEmpFk, that.employeeByEmpFk) && Objects.equals(scheduleByScheduleFk, that.scheduleByScheduleFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeescheduleId);
    }

    public Employee getEmployeeByEmpFk() {
        return employeeByEmpFk;
    }

    public void setEmployeeByEmpFk(Employee employeeByEmpFk) {
        this.employeeByEmpFk = employeeByEmpFk;
    }

    public Schedule getScheduleByScheduleFk() {
        return scheduleByScheduleFk;
    }

    public void setScheduleByScheduleFk(Schedule scheduleByScheduleFk) {
        this.scheduleByScheduleFk = scheduleByScheduleFk;
    }
}
