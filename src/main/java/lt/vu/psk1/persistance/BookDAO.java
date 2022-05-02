package lt.vu.psk1.persistance;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Setter;
import lt.vu.psk1.entities.Book;

@ApplicationScoped
public class BookDAO {

    // @Setter
    @PersistenceContext
    private EntityManager entityManager;

    // public List<Book> loadAll() {
    //     return entityManager.createNamedQuery("Book.findAll", Book.class).getResultList();
    // }

    public void persist(Book book) {
        this.entityManager.persist(book);
    }
}
