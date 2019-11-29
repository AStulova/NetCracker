package bsys.controller;

import bsys.model.Account;
import bsys.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class AccountController {
    private AccountService accountService;

    @Autowired
    public void setClientService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView allAccounts() {
        List<Account> account = accountService.allAccounts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AccountInfo");
        modelAndView.addObject("accountList", account);
        return modelAndView;
    }

    @RequestMapping(value = "/edit-account/{id}", method = RequestMethod.GET)
    public ModelAndView editAccountPage(@PathVariable int id) {
        Account account = accountService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditAccount");
        modelAndView.addObject("account", account);
        return modelAndView;
    }

    @RequestMapping(value = "/edit-account", method = RequestMethod.POST)
    public ModelAndView editAccount(@ModelAttribute("account") Account account) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/account");
        accountService.editAccount(account);
        return modelAndView;
    }

    @RequestMapping(value = "/add-account", method = RequestMethod.GET)
    public ModelAndView addAccountPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditAccount");
        return modelAndView;
    }

    @RequestMapping(value = "/add-account", method = RequestMethod.POST)
    public ModelAndView addAccount(@ModelAttribute("account") Account account) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/account");
        accountService.addAccount(account);
        return modelAndView;
    }

    @RequestMapping(value = "/delete-account/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAccount(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/account");
        Account account = accountService.getById(id);
        accountService.deleteAccount(account);
        return modelAndView;
    }
}
