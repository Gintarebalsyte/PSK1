package lt.vu.psk1.usecases;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
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

@Model
public class ReaderBooksMB implements Serializable {

    @Inject
    private BookMapper bookMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private BooksReaderMapper booksReaderMapper;

    @Getter
    @Setter
    private Account account;

    @Getter
    @Setter
    private Book bookToAdd = new Book();

    @Transactional
    public String addBookForReader() {
        if (bookMapper.getResultCount(bookToAdd.getTitle()) == 0) {
            bookMapper.insert(bookToAdd);
        }
        Book addedBook = bookMapper.findByName(bookToAdd.getTitle());
        BooksReader booksReader = new BooksReader();
        booksReader.setBookId(addedBook.getId());
        booksReader.setAccountId(this.account.getId());
        booksReaderMapper.insert(booksReader);
        return "/myBatis/readersAndBooks?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        Long readerId = Long.parseLong(requestParams.get("readerId"));
        this.account = accountMapper.selectByPrimaryKey(readerId);
    }
}
