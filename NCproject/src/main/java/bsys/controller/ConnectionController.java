package bsys.controller;

import bsys.model.Connection;
import bsys.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ConnectionController {
    private ConnectionService connectionService;

    @Autowired
    public void setConnectionService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public ModelAndView allConnections() {
        List<Connection> connection =  connectionService.allConnections();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ConnectionInfo");
        modelAndView.addObject("connectionList", connection);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditConnection");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addConnection(@ModelAttribute("client") Connection connection) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        connectionService.addConnection(connection);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteClient(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/services");
        Connection connection = connectionService.getById(id);
        connectionService.deleteConnection(connection);
        return modelAndView;
    }
}
