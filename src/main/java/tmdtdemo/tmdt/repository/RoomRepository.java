package tmdtdemo.tmdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tmdtdemo.tmdt.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findRoomById(Long id);
}
