package Controllers;

import Entity.Event;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Named
@RequestScoped
public class EventInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;

    public List<Event> getEventInfo() {
        return em.createNamedQuery("Event.allOrderByDate", Event.class).getResultList();
    }
}
