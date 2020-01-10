package app.service;

import app.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repos.StoreRepository;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    public Store findStore(int idStore) {
        return storeRepository.findByIdStore(idStore);
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public void setStorePlacement(String placement, int idStore) {
        storeRepository.setStorePlacement(placement, idStore);
    }

    public void updateStoreInfo(String name, String placement, double commission, int idStore) {
        storeRepository.updateStoreInfo(name, placement, commission, idStore);
    }

    public void deleteStore(int idStore) {
        storeRepository.deleteById(idStore);
    }

    public List<String> findByPlacement() {
        String placement1 = "Советский";
        String placement2 = "Сормовкий";
        return storeRepository.findByPlacement(placement1, placement2);
    }

    public List<String> getStores() {
        return storeRepository.getStores();
    }
}
