package tmdtdemo.tmdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmdtdemo.tmdt.entity.RoomSku;

import java.awt.print.Pageable;
import java.util.List;

public interface RoomSkuRepository extends JpaRepository<RoomSku,Long> {
    RoomSku findRoomSkuById(Long roomskuId);

}
