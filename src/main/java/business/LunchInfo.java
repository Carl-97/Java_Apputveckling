package business;

import Entity.Dagenslunch;
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
    public List<Dagenslunch> getTodaysLunch() {
        //TypedQuery<Dagenslunch> query = em.createQuery("SELECT e FROM Dagenslunch e", Dagenslunch.class);
        return em.createQuery("SELECT e FROM Dagenslunch e WHERE e.date = CURRENT_DATE", Dagenslunch.class).getResultList();
    }

    public Integer getNLunch(){
        TypedQuery<Dagenslunch> query = em.createQuery("SELECT e FROM Dagenslunch e", Dagenslunch.class);
        return query.getResultList().size();
    }
}
