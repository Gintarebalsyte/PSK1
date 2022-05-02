package lt.vu.psk1.usecases;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;
import lt.vu.psk1.entities.Account;
import lt.vu.psk1.persistance.AccountDAO;

@Model
public class ReaderAccounts implements Serializable {

    @Inject
    private AccountDAO accountDAO;

    @Getter
    @Setter
    private Account accountToCreate = new Account();

    @Getter
    private List<Account> allAccounts;

    @PostConstruct
    public void init() {
        loadAccounts();
    }

    public void loadAccounts() {
        this.allAccounts = accountDAO.loadAll();
    }

    @Transactional
    public String createAccount() {
        this.accountDAO.persist(accountToCreate);
        return "index?faces-redirect=true";
    }
}
