package controller;

import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.StoreService;

import java.util.List;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/store")
    public List<Store> findAll(){
        return storeService.findAllStores();
    }

    @GetMapping("/store/find")
    public ResponseEntity<Store> findById(@RequestParam int id) {
        Store store = storeService.findStore(id);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(store);
        }
    }

    @PostMapping("/store/add")
    public void addStore(@RequestBody Store store) {
        storeService.addStore(store);
    }

    @PatchMapping("/store/set/{id}/{placement}")
    public void setStorePlacement(@PathVariable int id, @PathVariable String placement) {
        storeService.setStorePlacement(placement, id);
    }

    @PutMapping("/store/update/{id}/{name}/{placement}/{commission}")
    public void updateStoreInfo(@PathVariable int id, @PathVariable String name, @PathVariable String placement, @PathVariable double commission) {
        storeService.updateStoreInfo(name, placement, commission, id);
    }

    @DeleteMapping("/store/delete/{id}")
    public void deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
    }
}
