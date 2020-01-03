package controller;

import model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.PurchaseService;

import java.util.List;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchase")
    public List<Purchase> findAll(){
        return purchaseService.findAllPurchases();
    }

    @GetMapping("/purchase/find")
    public ResponseEntity<Purchase> findById(@RequestParam int id) {
        Purchase purchase = purchaseService.findPurchase(id);
        if (purchase == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(purchase);
        }
    }

    @PostMapping("/purchase/add")
    public void addPurchase(@RequestBody Purchase purchase) {
        purchaseService.addPurchase(purchase);
    }

    @PatchMapping("/purchase/set/{id}/{number}")
    public void setPurchaseNumber(@PathVariable int id, @PathVariable String number) {
        purchaseService.setPurchaseNumber(number, id);
    }

    @PutMapping("/purchase/update/{id}/{date}/{idStore}/{idBuyer}/{idBook}/{number}/{total}")
    public void updatePurchaseInfo(@PathVariable int id, @PathVariable String date, @PathVariable int idStore, @PathVariable int idBuyer, @PathVariable int idBook, @PathVariable int number, @PathVariable double total) {
        purchaseService.updatePurchaseInfo(date, idStore, idBuyer, idBook, number, total, id);
    }

    @DeleteMapping("/purchase/delete/{id}")
    public void deletePurchase(@PathVariable int id) {
        purchaseService.deletePurchase(id);
    }
}
