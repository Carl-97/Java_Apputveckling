package Controllers;

import Entity.TodaysLunch;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

@Named
@RequestScoped
public class LunchInfo {
    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName() {
        return "LunchInfo";
    }



    public List<TodaysLunch> getTodaysLunch() {
        //TypedQuery<Dagenslunch> query = em.createQuery("SELECT e FROM Dagenslunch e", Dagenslunch.class);
        return em.createNamedQuery("getTodayLunch", TodaysLunch.class).getResultList();
        //return em.createQuery("SELECT e FROM Dagenslunch e WHERE e.date = CURRENT_DATE", Dagenslunch.class).getResultList();
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
