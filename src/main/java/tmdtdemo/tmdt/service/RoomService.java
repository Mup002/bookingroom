package tmdtdemo.tmdt.service;

import tmdtdemo.tmdt.dto.response.RoomResponse;

import java.util.List;

public interface RoomService {
    List<RoomResponse> getAllRoom();
    RoomResponse getRoomById(Long id);
}
