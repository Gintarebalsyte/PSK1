package lt.vu.psk1.mybatis.model;

public class BooksReader {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOKS_READER.ACCOUNT_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private Long accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOKS_READER.BOOK_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    private Long bookId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOKS_READER.ACCOUNT_ID
     *
     * @return the value of PUBLIC.BOOKS_READER.ACCOUNT_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOKS_READER.ACCOUNT_ID
     *
     * @param accountId the value for PUBLIC.BOOKS_READER.ACCOUNT_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOKS_READER.BOOK_ID
     *
     * @return the value of PUBLIC.BOOKS_READER.BOOK_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOKS_READER.BOOK_ID
     *
     * @param bookId the value for PUBLIC.BOOKS_READER.BOOK_ID
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}