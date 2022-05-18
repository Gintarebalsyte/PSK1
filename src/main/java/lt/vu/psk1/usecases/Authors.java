package lt.vu.psk1.usecases;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.decorators.AuthorDecorator;
import lt.vu.psk1.entities.Author;
import lt.vu.psk1.persistance.AuthorDAO;

@Model
public class Authors implements Serializable {

    @Inject
    private AuthorDAO authorDAO;

    @Inject
    AuthorDecorator authorDecorator;

    @Getter
    @Setter
    private Author authorToCreate = new Author();

    @Getter
    private List<Author> allAuthors;

    @PostConstruct
    public void init() {
        loadAccounts();
    }

    public void loadAccounts() {
        this.allAuthors = authorDAO.loadAll();
    }

    @Transactional
    public String createAuthor() {
        this.authorDAO.persist(authorToCreate);
        System.out.println(authorDecorator.authorDecorator("Created a new Author"));
        return "index?faces-redirect=true";
    }
}
