package lt.vu.psk1.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;

import lt.vu.psk1.mybatis.model.Account;

@Mapper
public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACCOUNT
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACCOUNT
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACCOUNT
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    Account selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACCOUNT
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    List<Account> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACCOUNT
     *
     * @mbg.generated Wed May 04 15:44:04 EEST 2022
     */
    int updateByPrimaryKey(Account record);
}