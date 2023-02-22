package business;

import Entity.TodaysLunch;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Named
@RequestScoped
public class LunchInfo {
    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName() {
        return "LunchInfo";
    }
    public TodaysLunch getTodaysLunch() {
        //TypedQuery<Dagenslunch> query = em.createQuery("SELECT e FROM Dagenslunch e", Dagenslunch.class);
        return em.createNamedQuery("getTodayLunch", TodaysLunch.class).getSingleResult();
        //return em.createQuery("SELECT e FROM Dagenslunch e WHERE e.date = CURRENT_DATE", Dagenslunch.class).getResultList();
    }

    public Integer getNLunch(){
        TypedQuery<TodaysLunch> query = em.createQuery("SELECT e FROM TodaysLunch e", TodaysLunch.class);
        return query.getResultList().size();
    }
}
