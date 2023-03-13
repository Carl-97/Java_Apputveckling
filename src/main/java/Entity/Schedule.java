package Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Schedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SCHEDULE_ID")
    private int scheduleId;
    @Basic
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic
    @Column(name = "START_TIME")
    private String start;
    @Basic
    @Column(name = "END_TIME")
    private String end;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return scheduleId == schedule.scheduleId && Objects.equals(date, schedule.date) && Objects.equals(start, schedule.start) && Objects.equals(end, schedule.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, date, start, end);
    }
}
