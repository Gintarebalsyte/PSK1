package lt.vu.psk1.usecases;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.mybatis.dao.BookMapper;
import lt.vu.psk1.mybatis.dao.BooksReaderMapper;
import lt.vu.psk1.mybatis.model.Account;
import lt.vu.psk1.mybatis.dao.AccountMapper;
import lt.vu.psk1.mybatis.model.Book;
import lt.vu.psk1.mybatis.model.BooksReader;
import lt.vu.psk1.qualifiers.Audio;
import lt.vu.psk1.qualifiers.BookTypeProcessor;
import lt.vu.psk1.qualifiers.EBook;
import lt.vu.psk1.qualifiers.EBookType;

@Model
public class ReaderBooksMB implements Serializable {

    @Inject
    private BookMapper bookMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private BooksReaderMapper booksReaderMapper;

    @Inject
    @EBook
    BookTypeProcessor bookTypeProcessor;

    @Inject
    @Any
    EBookType eBookType;

    @Getter
    @Setter
    private Account account;

    @Getter
    @Setter
    private Book bookToAdd = new Book();

    @Getter
    private List<Book> allExistingBooks;

    @Transactional
    public String addBookForReader(Long bookId) {
        if (booksReaderMapper.getResultCountByBookAndAccountId(bookId, this.account.getId()) == 0) {
            BooksReader booksReader = new BooksReader();
            booksReader.setBookId(bookId);
            booksReader.setAccountId(this.account.getId());
            booksReaderMapper.insert(booksReader);
            System.out.println(eBookType.bookType());
            System.out.println(bookTypeProcessor.bookType());
        }
        return "/myBatis/readersAndBooks?faces-redirect=true";
    }

    @Transactional
    public String addNewBookForReader() {
        if (bookMapper.getResultCountByBookTitle(bookToAdd.getTitle()) == 0) {
            bookMapper.insert(bookToAdd);
        }
        Book addedBook = bookMapper.findByName(bookToAdd.getTitle());
        BooksReader booksReader = new BooksReader();
        booksReader.setBookId(addedBook.getId());
        booksReader.setAccountId(this.account.getId());
        booksReaderMapper.insert(booksReader);
        System.out.println(eBookType.bookType());
        System.out.println(bookTypeProcessor.bookType());
        return "/myBatis/readersAndBooks?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        Long readerId = Long.parseLong(requestParams.get("readerId"));
        this.account = accountMapper.selectByPrimaryKey(readerId);
        this.allExistingBooks = this.bookMapper.selectAll();
    }
}
