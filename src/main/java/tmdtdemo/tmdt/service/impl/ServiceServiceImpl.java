package tmdtdemo.tmdt.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tmdtdemo.tmdt.dto.response.ServiceResponse;
import tmdtdemo.tmdt.entity.RoomDetails;
import tmdtdemo.tmdt.repository.RoomDetailRepository;
import tmdtdemo.tmdt.repository.ServiceRepository;
import tmdtdemo.tmdt.service.ServiceService;
import tmdtdemo.tmdt.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    private final RoomDetailRepository roomDetailRepository;

    @Override
    public List<ServiceResponse> getAll() {
        return Mapper.serviceToListReponse(serviceRepository.findAll()).stream().collect(Collectors.toList());
    }

    @Override
    public ServiceResponse getServiceById(Long id) {
        return Mapper.serviceToResponse(serviceRepository.findServiceById(id));
    }

    @Override
    public List<ServiceResponse> getAllServiceByRoom(Long id) {
       List<RoomDetails> roomDetails = roomDetailRepository.findRoomDetailsByRoomId(id);
       List<ServiceResponse> responses = new ArrayList<>();
       for(RoomDetails r : roomDetails){
           responses.add(Mapper.serviceToResponse(r.getService()));
       }
       return responses;
    }
}
