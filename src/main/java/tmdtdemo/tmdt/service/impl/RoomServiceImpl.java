package tmdtdemo.tmdt.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tmdtdemo.tmdt.dto.response.CustomRoomResponse;
import tmdtdemo.tmdt.dto.response.RoomResponse;

import tmdtdemo.tmdt.dto.response.RoomSkuResponse;
import tmdtdemo.tmdt.dto.response.ServiceResponse;
import tmdtdemo.tmdt.entity.Room;
import tmdtdemo.tmdt.entity.RoomDetails;
import tmdtdemo.tmdt.entity.RoomSku;
import tmdtdemo.tmdt.repository.RoomDetailRepository;
import tmdtdemo.tmdt.repository.RoomRepository;
import tmdtdemo.tmdt.repository.RoomSkuRepository;
import tmdtdemo.tmdt.repository.ServiceRepository;
import tmdtdemo.tmdt.service.RoomService;
import tmdtdemo.tmdt.utils.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomDetailRepository roomDetailRepository;
    private final RoomSkuRepository roomSkuRepository;

    @Override
    public List<RoomResponse> getAllRoom() {
        List<Room> rooms = roomRepository.findAll().stream().toList();
        List<RoomResponse> responses = new ArrayList<>();
        for(Room r : rooms){
            RoomResponse response = new RoomResponse();
            response.setId(r.getId());
            response.setRoomType(r.getType());
            response.setRoomName(r.getName());
            response.setAvailable(r.isAvailable());
            response.setDescription(r.getDescription());
            response.setConditions(r.getConditions());
            response.setRemainRoom(r.getRemainRoom());
            List<String> item = Arrays.stream(r.getItem().split("-")).collect(Collectors.toList());
            response.setItem(item);
            List<RoomDetails> roomDetails = roomDetailRepository.findRoomDetailsByRoomId(r.getId());
            List<ServiceResponse> services = new ArrayList<>();
            for(RoomDetails roomD : roomDetails){
                services.add(Mapper.serviceToResponse(roomD.getService()));
            }
            response.setServiceResponse(services);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public RoomResponse getRoomById(Long id) {
        return Mapper.roomToResponse(roomRepository.findRoomById(id));
    }

    @Override
    public RoomSkuResponse getAllRoomSkuWithPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<RoomSku> roomSkuPage = roomSkuRepository.findAll(pageable);
        List<RoomSku> roomSkus = roomSkuPage.getContent();
        return new RoomSkuResponse(
                Mapper.roomToListCustomRoomResponse(roomSkus),
                pageNumber,
                pageSize,
                roomSkuPage.getTotalPages(),
                (int) roomSkuPage.getTotalElements(),
                roomSkuPage.isLast()
        );
    }

    @Override
    public RoomSkuResponse getAllRoomSkuWithPaginationWithSoring(Integer pageNumber, Integer pageSize, String sortBy, String dir) {
        Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<RoomSku> roomSkuPage = roomSkuRepository.findAll(pageable);
        List<RoomSku> roomSkus = roomSkuPage.getContent();
        return new RoomSkuResponse(
                Mapper.roomToListCustomRoomResponse(roomSkus),
                pageNumber,
                pageSize,
                roomSkuPage.getTotalPages(),
                (int) roomSkuPage.getTotalElements(),
                roomSkuPage.isLast()
        );
    }
}

