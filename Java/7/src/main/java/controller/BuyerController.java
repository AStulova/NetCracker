package controller;

import model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BuyerService;

import java.util.List;

@Controller
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyer")
    public List<Buyer> findAll(){
        return buyerService.findAllBuyers();
    }

    @GetMapping("/buyer/find")
    public ResponseEntity<Buyer> findById(@RequestParam int id) {
        Buyer buyer = buyerService.findBuyer(id);
        if (buyer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(buyer);
        }
    }

    @PostMapping("/buyer/add")
    public void addBuyer(@RequestBody Buyer buyer) {
        buyerService.addBuyer(buyer);
    }

    @PatchMapping("/buyer/set/{id}/{residence}")
    public void setBuyerResidence(@PathVariable int id, @PathVariable String residence) {
        buyerService.setBuyerResidence(residence, id);
    }

    @PutMapping("/buyer/update/{id}/{surname}/{residence}/{discount}")
    public void updateBuyerInfo(@PathVariable int id, @PathVariable String surname, @PathVariable String residence, @PathVariable int discount) {
        buyerService.updateBuyerInfo(surname, residence, discount, id);
    }

    @DeleteMapping("/buyer/delete/{id}")
    public void deleteBuyer(@PathVariable int id) {
        buyerService.deleteBuyer(id);
    }
}
