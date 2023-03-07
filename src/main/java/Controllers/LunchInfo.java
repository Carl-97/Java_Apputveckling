package Controllers;

import Entity.TodaysLunch;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

@Named
@RequestScoped
public class LunchInfo {

    private int id;
    private String description;
    private String name;
    private Date date;
    private Integer price;
    @PersistenceContext(name = "default")
    private EntityManager em;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void insert() {
        TodaysLunch lunch = new TodaysLunch(description, date, name, price);
        em.persist(lunch);
    }

    public void delete() {
        TodaysLunch lunch = em.find(TodaysLunch.class, id);
        if(lunch != null) {
            em.remove(lunch);
        }
    }

    public List<TodaysLunch> getTodaysLunch() {
        return em.createNamedQuery("getTodayLunch", TodaysLunch.class).getResultList();
    }

    public List<TodaysLunch> getTLunchConst() {
        return em.createQuery("SELECT e FROM TodaysLunch e WHERE e.id = 1", TodaysLunch.class).getResultList();
    }

    public List<TodaysLunch> getWeeklyLunch() {
        return em.createNamedQuery("Lunch.all", TodaysLunch.class).getResultList();
    }

    public List<TodaysLunch> getAllByDate() {
        return em.createNamedQuery("Lunch.allOrderByDate", TodaysLunch.class).getResultList();
    }

    public Integer getNLunch(){
        TypedQuery<TodaysLunch> query = em.createQuery("SELECT e FROM TodaysLunch e", TodaysLunch.class);
        return query.getResultList().size();
    }
    public String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d");
        return date.format(formatter);
    }
    public String getWeek() {
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        return Integer.toString(week);
    }



}
