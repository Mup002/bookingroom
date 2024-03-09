package tmdtdemo.tmdt.utils;

import tmdtdemo.tmdt.dto.response.RefreshTokenResponse;
import tmdtdemo.tmdt.dto.response.RoomResponse;
import tmdtdemo.tmdt.dto.response.ServiceResponse;
import tmdtdemo.tmdt.entity.RefreshToken;
import tmdtdemo.tmdt.entity.Room;
import tmdtdemo.tmdt.entity.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    // map entity user to response
    public static RefreshTokenResponse refreshTokenToResponse(RefreshToken rf){
        RefreshTokenResponse response = new RefreshTokenResponse();
        response.setToken(rf.getRefreshToken());
        response.setExpiration(rf.getRefreshExpiration());
        return response;
    }

    // map entity service to response
    public static ServiceResponse serviceToResponse(Service sv){
        ServiceResponse response = new ServiceResponse();
        response.setId(sv.getId());
        response.setDescription(sv.getDescription());
        response.setDetails(sv.getDetails());
        response.setPrice(sv.getPrice());
        return response;
    }

    // map list entity service to list response
    public static List<ServiceResponse> serviceToListReponse(List<Service> svLst){
        List<ServiceResponse> responses = new ArrayList<>();
        for(Service s : svLst){
            responses.add(serviceToResponse(s));
        }
        return responses;
    }

    // map entity room to response
    public static RoomResponse roomToResponse(Room r){
        RoomResponse response = new RoomResponse();
        response.setId(r.getId());
        response.setNumber(r.getNumber());
        response.setRoomName(r.getName());
        response.setRoomType(r.getType());
        response.setConditions(r.getConditions());
        response.setDescription(r.getDescription());
        response.setRemainRoom(r.getRemainRoom());
        response.setAvailable(r.isAvailable());
        List<String> itemLst = Arrays.stream(r.getItem().split("-")).collect(Collectors.toList());
        response.setItem(itemLst);
        return response;
    }

    // map list entity room to response
    public static List<RoomResponse> roomToListResponse(List<Room> rooms){
        List<RoomResponse> responses = new ArrayList<>();
        for(Room r : rooms){
            responses.add(roomToResponse(r));
        }
        return responses;
    }
}
