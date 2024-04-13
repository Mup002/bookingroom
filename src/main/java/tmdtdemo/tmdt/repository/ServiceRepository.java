package tmdtdemo.tmdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmdtdemo.tmdt.entity.Service;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Service findServiceById(Long id);
}
