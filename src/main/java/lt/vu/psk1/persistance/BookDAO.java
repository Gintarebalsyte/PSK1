package lt.vu.psk1.persistance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import lt.vu.psk1.entities.Book;

@ApplicationScoped
public class BookDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(Book book) {
        this.entityManager.persist(book);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Book findOne(Long id){
        return entityManager.find(Book.class, id);
    }

    public Book update(Book book){
        return entityManager.merge(book);
    }
}
