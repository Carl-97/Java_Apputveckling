package business;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Named
@RequestScoped
public class EventInfo {

    @PersistenceContext(name = "default")
    private EntityManager em;


}
