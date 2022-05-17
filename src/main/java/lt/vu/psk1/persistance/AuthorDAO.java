package lt.vu.psk1.persistance;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import lt.vu.psk1.entities.Author;

@ApplicationScoped
public class AuthorDAO {

    @Inject
    private EntityManager entityManager;

    public List<Author> loadAll() {
        return entityManager.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public void persist(Author author) {
        this.entityManager.persist(author);
    }

    public Author findOne(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Author findByName(String firstName, String lastName) {
        try {
            return entityManager.createNamedQuery("Author.findByName", Author.class)
                    .setParameter("firstName", firstName)
                    .setParameter("lastName", lastName)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }
}
