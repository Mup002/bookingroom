package tmdtdemo.tmdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmdtdemo.tmdt.entity.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {
    OrderDetails findOrderDetailsById(Long id);
}
