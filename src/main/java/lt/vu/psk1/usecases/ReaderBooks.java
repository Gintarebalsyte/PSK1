// package lt.vu.psk1.usecases;
//
// import java.io.Serializable;
// import java.util.List;
// import java.util.Map;
//
// import javax.annotation.PostConstruct;
// import javax.enterprise.inject.Model;
// import javax.faces.context.FacesContext;
// import javax.inject.Inject;
// import javax.transaction.Transactional;
//
// import lombok.Getter;
// import lombok.Setter;
// import lt.vu.psk1.entities.Account;
// import lt.vu.psk1.entities.Author;
// import lt.vu.psk1.entities.Book;
// import lt.vu.psk1.persistance.AccountDAO;
// import lt.vu.psk1.persistance.AuthorDAO;
// import lt.vu.psk1.persistance.BookDAO;
//
// @Model
// public class ReaderBooks implements Serializable {
//
//     @Inject
//     private AccountDAO accountDAO;
//
//     @Inject
//     BookDAO bookDAO;
//
//     @Getter
//     private List<Book> addedBooks;
//
//     @Getter
//     @Setter
//     private Account reader;
//
//     @Getter
//     @Setter
//     private Book bookToAdd = new Book();
//
//     @PostConstruct
//     public void init() {
//         Map<String, String> requestParameters =
//                 FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//         Long readerId = Long.parseLong(requestParameters.get("readerId"));
//         this.reader = accountDAO.findOne(readerId);
//     }
//
//     // public void loadAddedBooks() {
//     //     this.addedBooks = accountDAO.loadAll();
//     // }
//
//     @Transactional
//     public String addBook() {
//         reader.getBookList().add(this.bookToAdd);
//         this.accountDAO.persist(reader);
//         return "books?faces-redirect=true&authorId=" + this.author.getId();
//     }
// }
