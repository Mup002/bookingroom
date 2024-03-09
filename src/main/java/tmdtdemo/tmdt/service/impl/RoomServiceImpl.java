package tmdtdemo.tmdt.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tmdtdemo.tmdt.dto.response.RoomResponse;
import tmdtdemo.tmdt.repository.RoomRepository;
import tmdtdemo.tmdt.service.RoomService;
import tmdtdemo.tmdt.utils.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public List<RoomResponse> getAllRoom() {
        return Mapper.roomToListResponse(roomRepository.findAll()).stream().collect(Collectors.toList());
    }

    @Override
    public RoomResponse getRoomById(Long id) {
        return Mapper.roomToResponse(roomRepository.findRoomById(id));
    }
}
