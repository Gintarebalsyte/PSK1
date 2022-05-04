package lt.vu.psk1.usecases;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.mybatis.dao.BookMapper;
import lt.vu.psk1.mybatis.model.Book;

@Model
public class BookReadersMB implements Serializable {

    @Inject
    private BookMapper bookMapper;

    @Getter
    @Setter
    private Book book;

    @Getter
    @Setter
    private Book bookToCreate = new Book();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long bookId = Long.parseLong(requestParameters.get("bookId"));
        this.book = bookMapper.selectByPrimaryKey(bookId);
    }

}
