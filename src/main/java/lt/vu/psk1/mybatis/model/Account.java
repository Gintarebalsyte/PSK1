package lt.vu.psk1.mybatis.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCOUNT.ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCOUNT.PASSWORD
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACCOUNT.USERNAME
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private String username;

    private List<Book> books;
}