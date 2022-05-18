package lt.vu.psk1.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account AS a"),
        @NamedQuery(name = "Account.findOne", query = " SELECT a FROM Account  AS a WHERE a.username = :username AND a.password = :password")
})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Serial
    private static final long serialVersionUID = -3833941707753425798L;

    @Size(max = 20)
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Size(max = 20)
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column
    @ManyToMany
    @JoinTable(name = "BOOKS_READER",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    List<Book> books = new ArrayList<>();
}
