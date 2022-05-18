package lt.vu.psk1.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author AS a"),
        @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author AS a WHERE a.firstName = :firstName AND a.lastName = :lastName")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AUTHOR")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Serial
    private static final long serialVersionUID = 3459376443491921507L;

    @Size(max = 20)
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(max = 20)
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
