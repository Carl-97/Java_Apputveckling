package Controllers;

import Entity.TodaysLunch;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Named
@RequestScoped
public class LunchInfo {
    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName() {
        return "LunchInfo";
    }
    public List<TodaysLunch> getTodaysLunch() {
        return em.createNamedQuery("Lunch.today", TodaysLunch.class).getResultList();
    }

    public List<TodaysLunch> getTLunchConst() {
        return em.createQuery("SELECT e FROM TodaysLunch e WHERE e.lunchId = 1", TodaysLunch.class).getResultList();
    }

    public Integer getNLunch(){
        TypedQuery<TodaysLunch> query = em.createQuery("SELECT e FROM TodaysLunch e", TodaysLunch.class);
        return query.getResultList().size();
    }
}
