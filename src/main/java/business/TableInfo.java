package business;

import Entity.Dinnertable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Named
@RequestScoped
public class TableInfo
{
    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getName(){
        return "Tables";
    }
    public Integer getNTables(){
        TypedQuery<Dinnertable> query = em.createQuery("SELECT d FROM Dinnertable d", Dinnertable.class);
        return query.getResultList().size();
    }
}
