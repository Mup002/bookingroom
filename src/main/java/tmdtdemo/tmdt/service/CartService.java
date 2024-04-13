package tmdtdemo.tmdt.service;

import tmdtdemo.tmdt.dto.request.CartRequest;
import tmdtdemo.tmdt.dto.response.CartResponse;

public interface CartService {
    CartResponse addToCard(CartRequest cardRequest, String username);
    CartResponse getByUsername(String username);
}
