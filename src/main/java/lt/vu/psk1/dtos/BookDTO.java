package lt.vu.psk1.dtos;

import org.h2.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.vu.psk1.entities.Book;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String authorFirstName;
    private String authorLastName;
    private String authorName;
    private String title;
    private String ISBNCode;

    public static BookDTO of(Book book) {
        if (book == null) {
            return null;
        }

        return BookDTO.builder()
                .authorName(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName())
                .title(book.getTitle())
                .ISBNCode(book.getISBNCode())
                .build();
    }
}
