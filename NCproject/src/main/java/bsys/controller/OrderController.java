package bsys.controller;

import bsys.model.Client;
import bsys.model.Order;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public ModelAndView allOrders() {
        List<Order> order = orderService.allOrders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderPage");
        modelAndView.addObject("orderList", order);
        return modelAndView;
    }

    @PostMapping(value = "/order-edit/{id}/{statusOrder}")
    public ModelAndView editOrder(@PathVariable int id, String statusOrder) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.editOrderStatus(statusOrder, id);
        return modelAndView;
    }

    @GetMapping(value = "/order-add")
    public ModelAndView addOrderPage() {
        List<Order> order = orderService.allOrders(); // +
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("orderList", order); // +
        return modelAndView;
    }

    @PostMapping(value = "/order-add")
    public ModelAndView addOrder(@AuthenticationPrincipal Client client, @ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        order.setIdClient(client);
        orderService.addOrder(order);
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }

    @GetMapping(value = "/order-delete/{id}")
    public ModelAndView deleteOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        Order order = orderService.getById(id);
        orderService.deleteOrder(order);
        return modelAndView;
    }
}
