package bsys.service.account;

import bsys.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO;

    @Autowired
    public void setClientDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Transactional
    public List<Account> allAccounts() {
        return accountDAO.allAccounts();
    }

    @Transactional
    public void addAccount(Account account) {
        accountDAO.addAccount(account);
    }

    @Transactional
    public void deleteAccount(Account account) {
        accountDAO.deleteAccount(account);
    }

    @Transactional
    public void editAccount(Account account) {
        accountDAO.editAccount(account);
    }

    @Transactional
    public Account getById(int idAccount) {
        return accountDAO.getById(idAccount);
    }
}