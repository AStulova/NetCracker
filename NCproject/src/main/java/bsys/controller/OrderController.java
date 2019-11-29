package bsys.controller;

import bsys.model.Order;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView allOrders() {
        List<Order> order = orderService.allOrders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderInfo");
        modelAndView.addObject("orderList", order);
        return modelAndView;
    }

    @RequestMapping(value = "/edit-order", method = RequestMethod.POST)
    public ModelAndView editOrder(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.editOrder(order);
        return modelAndView;
    }

    @RequestMapping(value = "/add-order", method = RequestMethod.GET)
    public ModelAndView addOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditOrder");
        return modelAndView;
    }

    @RequestMapping(value = "/add-order", method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        orderService.addOrder(order);
        return modelAndView;
    }

    @RequestMapping(value = "/delete-order/{id}", method = RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order");
        Order order = orderService.getById(id);
        orderService.deleteOrder(order);
        return modelAndView;
    }
}
