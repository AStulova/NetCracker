package bsys.service.account;

import bsys.model.Account;
import java.util.List;

public interface AccountDAO {
    List<Account> allAccounts();
    void addAccount(Account account);
    void deleteAccount(Account account);
    void editAccount(Account account);
    Account getById(int idAccount);
}
