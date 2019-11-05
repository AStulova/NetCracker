package bsys.controller;

import bsys.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
    private static Client client;
    static {
        client = new Client();
        client.setId_client(5438);
        client.setFull_name("Courteney Cox");
        client.setPhone("+79106845169");
        client.setEmail("CourteneyCox@gmail.com");
        client.setPersonal_account(2568452);
        client.setMoney(578.47);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allClients() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ClientInfo");
        modelAndView.addObject("client", client);
        return modelAndView;
    }
}