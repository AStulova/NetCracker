package bsys.controller;

import bsys.model.Bill;
import bsys.service.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class BillController {
    private BillService billService;

    @Autowired
    public void setClientService(BillService billService) {
        this.billService = billService;
    }

    @GetMapping(value = "/bill/{id}")
    public ModelAndView allBills(@PathVariable int id) {
        List<Bill> bill = billService.allBills(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillPage");
        modelAndView.addObject("billList", bill);
        return modelAndView;
    }


    /*@PostMapping(value = "/bill-edit")
    public ModelAndView editBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        billService.editBill(bill);
        return modelAndView;
    }*/

    @GetMapping(value = "/bill-add")
    public ModelAndView addBillPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("old/BillEdit");
        return modelAndView;
    }

    @PostMapping(value = "/bill-add")
    public ModelAndView addBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        billService.addBill(bill);
        return modelAndView;
    }

    @GetMapping(value = "/bill-delete/{id}")
    public ModelAndView deleteBill(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        Bill bill = billService.getById(id);
        billService.deleteBill(bill);
        return modelAndView;
    }
}
