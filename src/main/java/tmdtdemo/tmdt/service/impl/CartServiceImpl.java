package tmdtdemo.tmdt.service.impl;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tmdtdemo.tmdt.dto.request.CartRequest;
import tmdtdemo.tmdt.dto.response.CartResponse;
import tmdtdemo.tmdt.dto.response.ServiceResponse;
import tmdtdemo.tmdt.service.BaseRedisService;
import tmdtdemo.tmdt.service.CartService;
import tmdtdemo.tmdt.service.ServiceService;
import tmdtdemo.tmdt.utils.ChangeObject;
import tmdtdemo.tmdt.utils.DateFormat;
import tmdtdemo.tmdt.utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final BaseRedisService baseRedisService;
    private final ServiceService serviceService;
    @Override
    public CartResponse addToCard(CartRequest cardRequest, String username) {
        CartResponse cardResponse = new CartResponse();
        cardResponse.setUsername(username);
        cardResponse.setCreatedAt(DateFormat.dateFormatWithLocate(String.valueOf(new Date())));
        cardResponse.setCheckIn(cardRequest.getCheckIn());
        cardResponse.setCheckOut(cardRequest.getCheckOut());
        cardResponse.setRoomName(cardRequest.getRoomName());
        cardResponse.setTotal(cardRequest.getTotal());
        cardResponse.setRoomId(cardRequest.getRoomId());
        cardResponse.setCodeRoom(cardRequest.getCodeRoom());
        cardResponse.setPeopleDetails(cardRequest.getPeopleDetails());
        cardResponse.setServiceResponses(serviceService.getServiceById(cardRequest.getServiceId()));
        baseRedisService.hashSet(HelperUtils.cartBuilderRedisKey(username), "cartData", ChangeObject.objectToJson(cardResponse));
        baseRedisService.setTimeToLive(HelperUtils.cartBuilderRedisKey(username),5);
        return cardResponse;
    }

    @Override
    public CartResponse getByUsername(String username) {
        String cartKey = HelperUtils.cartBuilderRedisKey(username);
        CartResponse cartResponse = new CartResponse();
        if(baseRedisService.hashExists(cartKey,"cartData")){
            Object object = baseRedisService.hashGet(cartKey,"cartData");
            String jsonString = (String) object; // Giả sử dữ liệu được lưu trữ dưới dạng chuỗi JSON
            Gson gson = new Gson();
            cartResponse = gson.fromJson(jsonString, CartResponse.class);

            log.info("cart has exists");

        }
        return cartResponse;
    }
}
