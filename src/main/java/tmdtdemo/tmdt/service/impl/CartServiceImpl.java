package tmdtdemo.tmdt.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tmdtdemo.tmdt.dto.request.CartRequest;
import tmdtdemo.tmdt.dto.response.CartResponse;
import tmdtdemo.tmdt.service.BaseRedisService;
import tmdtdemo.tmdt.service.CartService;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final BaseRedisService baseRedisService;
//    private final RoomService roomService;
//    private final ServiceService serviceService;
    @Override
    public CartResponse addToCard(CartRequest cardRequest) {
        CartResponse cardResponse = new CartResponse();
        cardResponse.setUserId(cardRequest.getUserId());
        baseRedisService.hashSet("card_" + cardRequest.getUserId(),"userId",cardRequest.getUserId());

        cardResponse.setCreatedAt(String.valueOf(new Date()));
        baseRedisService.hashSet("card_" + cardRequest.getUserId(),"createdAt",String.valueOf(new Date()));

        cardResponse.setCheckIn(cardRequest.getCheckIn());
        baseRedisService.hashSet("card_" + cardRequest.getUserId(),"checkIn",cardRequest.getCheckIn());

        cardResponse.setCheckOut(cardRequest.getCheckOut());
        baseRedisService.hashSet("card_" + cardRequest.getUserId(), "checkOut",cardRequest.getCheckOut());

        cardResponse.setRoomName(cardRequest.getRoomName());
        baseRedisService.hashSet("card_" + cardRequest.getUserId(),"roomName",cardRequest.getRoomName());

        cardResponse.setTotal(cardRequest.getTotal());
        baseRedisService.hashSet("card_" + cardRequest.getUserId(),"total",cardRequest.getTotal());
        return null;
    }
}
