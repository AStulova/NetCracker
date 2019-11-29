package bsys.controller;

import bsys.model.Connection;
import bsys.service.connection.ConnectionService;
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

    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    public ModelAndView allConnections() {
        List<Connection> connection =  connectionService.allConnections();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ConnectionInfo");
        modelAndView.addObject("connectionList", connection);
        return modelAndView;
    }

    @RequestMapping(value = "/add-connection", method = RequestMethod.GET)
    public ModelAndView addConnectionPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditConnection");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-connection/{id}", method = RequestMethod.GET)
    public ModelAndView editConnectionPage(@PathVariable int id) {
        Connection connection = connectionService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditConnection");
        modelAndView.addObject("connection", connection);
        return modelAndView;
    }

    @RequestMapping(value = "/add-connection", method = RequestMethod.POST)
    public ModelAndView addConnection(@ModelAttribute("connection") Connection connection) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/connection");
        connectionService.addConnection(connection);
        return modelAndView;
    }

    @RequestMapping(value = "/delete-connection/{id}", method = RequestMethod.GET)
    public ModelAndView deleteConnection(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/connection");
        Connection connection = connectionService.getById(id);
        connectionService.deleteConnection(connection);
        return modelAndView;
    }
}
