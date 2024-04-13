package tmdtdemo.tmdt.service;

import org.springframework.data.domain.Page;
import tmdtdemo.tmdt.dto.response.CustomRoomResponse;
import tmdtdemo.tmdt.dto.response.RoomResponse;
import tmdtdemo.tmdt.dto.response.RoomSkuResponse;
import tmdtdemo.tmdt.entity.RoomSku;

import java.util.List;

public interface RoomService {
    List<RoomResponse> getAllRoom();
    RoomResponse getRoomById(Long id);

    RoomSkuResponse getAllRoomSkuWithPagination(Integer pageNumber, Integer pageSize);
    RoomSkuResponse getAllRoomSkuWithPaginationWithSoring(Integer pageNumber, Integer pageSize, String sortBy, String dir);
}
