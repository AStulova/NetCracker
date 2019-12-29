package bsys.controller;

import bsys.model.Order;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    // ??? и Add, и Edit на одной странице
    @PostMapping(value = "/order-edit")
    public ModelAndView editOrder(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.editOrder(order);
        return modelAndView;
    }

    @GetMapping(value = "/order-add")
    public ModelAndView addOrderPage() {
        List<Order> order = orderService.allOrders(); // +
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderEdit");
        modelAndView.addObject("orderList", order); // +
        return modelAndView;
    }

    @PostMapping(value = "/order-add")
    public ModelAndView addOrder(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.addOrder(order);
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
