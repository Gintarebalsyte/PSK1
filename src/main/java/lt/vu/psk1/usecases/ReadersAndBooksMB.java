package lt.vu.psk1.usecases;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.mybatis.dao.AccountMapper;
import lt.vu.psk1.mybatis.model.Account;

@Model
public class ReadersAndBooksMB implements Serializable {

    @Inject
    private AccountMapper accountMapper;

    @Getter
    private List<Account> allReaders;

    @Getter
    @Setter
    private Account readerToCreate = new Account();

    @PostConstruct
    private void init() {
        loadAllReaders();
    }

    @Transactional
    public String createReader() {
        accountMapper.insert(readerToCreate);
        return "/myBatis/readersAndBooks?faces-redirect=true";
    }

    private void loadAllReaders() {
        allReaders = accountMapper.selectAll();
    }
}
