package lt.vu.psk1.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book AS b")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Long version;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ISBN_CODE", nullable = false)
    private String ISBNCode;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    @ManyToMany(mappedBy = "books")
    List<Account> readers;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return id.equals(book.id) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
