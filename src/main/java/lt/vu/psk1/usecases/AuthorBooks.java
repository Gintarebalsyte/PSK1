package lt.vu.psk1.usecases;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.alternatives.Message;
import lt.vu.psk1.entities.Author;
import lt.vu.psk1.entities.Book;
import lt.vu.psk1.interceptors.LoggedInvocation;
import lt.vu.psk1.persistance.AuthorDAO;
import lt.vu.psk1.persistance.BookDAO;

@Model
public class AuthorBooks implements Serializable {

    @Inject
    private AuthorDAO authorDAO;

    @Inject
    private BookDAO bookDAO;

    @Inject
    private Message message;

    @Getter
    @Setter
    private Author author;

    @Getter
    @Setter
    private Book bookToCreate = new Book();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long authorId = Long.parseLong(requestParameters.get("authorId"));
        this.author = authorDAO.findOne(authorId);
    }

    @LoggedInvocation
    @Transactional
    public String createEBook() {
        bookToCreate.setAuthor(this.author);
        bookDAO.persist(bookToCreate);
        System.out.println(message.writeMessage());
        return "books?faces-redirect=true&authorId=" + this.author.getId();
    }

    @LoggedInvocation
    @Transactional
    public String createBook() {
        bookToCreate.setAuthor(this.author);
        bookDAO.persist(bookToCreate);
        System.out.println(message.writeMessage());
        return "books?faces-redirect=true&authorId=" + this.author.getId();
    }

    public void assignISBNCode(String ISBNCode) {
        this.bookToCreate.setISBNCode(ISBNCode);
    }
}
