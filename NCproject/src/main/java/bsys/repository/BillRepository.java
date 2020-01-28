package bsys.repository;

import bsys.model.Bill;
import bsys.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findAllByClient(Client client);

    @Query(value = "perform generatebill(?1) ", nativeQuery = true)
    void generateBills(int idClient);
}
