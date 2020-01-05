package bsys.repository;

import bsys.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findAllByIdClient(int id);

}
