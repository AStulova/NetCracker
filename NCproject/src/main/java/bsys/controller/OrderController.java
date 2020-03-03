package bsys.controller;

import bsys.model.Client;
import bsys.model.Order;
import bsys.service.client.ClientService;
import bsys.service.order.OrderService;
import bsys.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private OrderService orderService;
    private ClientService clientService;
    private ProductService productService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView ordersByAuthClientPage() {
        Client client = clientService.getAuthClient();
        List<Order> orderList = orderService.getOrders(client);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderPage");
        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("role", client.getRole());
        return modelAndView;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping(value = "/{idClient}")
    public ModelAndView OrdersByClientPage(@PathVariable int idClient) {
        String role = clientService.getAuthClient().getRole();
        Client client = clientService.getById(idClient);
        List<Order> orderList = orderService.getOrders(client);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderPage");
        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("curClient", client.getIdClient());
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    @GetMapping(value = "/activate/{idOrder}")
    public ModelAndView activateOrder(@PathVariable int idOrder) {
        orderService.activateOrder(idOrder);
        return getModelAndView(idOrder);
    }

    @GetMapping(value = "/cancel/{idOrder}")
    public ModelAndView cancelOrder(@PathVariable int idOrder) {
        orderService.cancelOrder(idOrder);
        return getModelAndView(idOrder);
    }

    private ModelAndView getModelAndView(@PathVariable int idOrder) {
        ModelAndView modelAndView = new ModelAndView();
        Client curClient = clientService.getAuthClient();
        int idClientByOrder = orderService.getById(idOrder).getClient().getIdClient();
        if (curClient.getRole().equals("EMPLOYEE") && curClient.getIdClient() != idClientByOrder) {
            modelAndView.setViewName("redirect:/order/" + idClientByOrder);
        }
        else {
            modelAndView.setViewName("redirect:/order");
        }
        return modelAndView;
    }


}
