package lt.vu.psk1.mybatis.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.TITLE
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.AUTHOR_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private Long authorId;

    private List<Account> readers;
}