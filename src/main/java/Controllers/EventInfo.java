package Controllers;

import Entity.Event;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.sql.Date;
import java.util.List;

@Named
@RequestScoped
public class EventInfo {

    private String description;
    private Date date;
    private String name;
    private Integer id;
    @PersistenceContext(name = "default")
    private EntityManager em;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void insert() {
        Event event = new Event(description, date, name);
        em.persist(event);
    }

    public void delete() {
        Event event = em.find(Event.class, id);
        if(event != null) {
            em.remove(event);
        }
    }

    public List<Event> getEventInfo() {
        return em.createNamedQuery("Event.allOrderByDate", Event.class).getResultList();
    }
}
