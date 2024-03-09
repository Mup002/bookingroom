package tmdtdemo.tmdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmdtdemo.tmdt.entity.RoomDetails;

public interface RoomDetailsService extends JpaRepository<RoomDetails, Long> {
}
