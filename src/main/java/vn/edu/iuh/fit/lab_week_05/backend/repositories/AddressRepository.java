package vn.edu.iuh.fit.lab_week_05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_05.backend.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
