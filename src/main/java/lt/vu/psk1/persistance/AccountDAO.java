package lt.vu.psk1.persistance;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import lombok.Setter;
import lt.vu.psk1.entities.Account;
import lt.vu.psk1.entities.Author;
import lt.vu.psk1.entities.Book;

@ApplicationScoped
public class AccountDAO {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public List<Account> loadAll() {
        return entityManager.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    // public List<Book> loadBooks() {
    //     return entityManager.createNamedQuery("")
    // }

    public void persist(Account account) {
        this.entityManager.persist(account);
    }

    public Account findOne(Long id) {
        return entityManager.find(Account.class, id);
    }

    public Account findByUsernameAndPassword(String username, String password) {
        try {
            return entityManager.createNamedQuery("Account.findOne", Account.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }
}
