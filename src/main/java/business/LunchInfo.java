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
    @PersistenceContext
    private EntityManager em;

    public List<Dagenslunch> getTodaysLunch() {
        //TypedQuery<Dagenslunch> query = em.createQuery("", Dagenslunch.class).getResultList();

        return em.createQuery("SELECT e FROM Dagenslunch e", Dagenslunch.class).getResultList();
    }
}
