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
public class LogInReader implements Serializable {

    @Inject
    private AccountDAO accountDAO;

    @Getter
    @Setter
    private Account accountToLogin = new Account();

    // @Getter
    // private List<Account> allAccounts;

    // @PostConstruct
    // public void init() {
    //     loadAccounts();
    // }

    // public void loadAccounts() {
    //     this.allAccounts = accountDAO.loadAll();
    // }

    @Transactional
    public String logInAccount() {
        Account attempt = accountDAO.findByUsernameAndPassword(this.accountToLogin.getUsername(), this.accountToLogin.getPassword());

        if (attempt != null) {
            return "index?faces-redirect=true";
            // return "readerBooks?faces-redirect=true&readerId=" + attempt.getId();
        } else {
            return "index?faces-redirect=true";
        }
    }
}
