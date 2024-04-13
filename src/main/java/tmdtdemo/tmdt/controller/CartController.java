package tmdtdemo.tmdt.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdtdemo.tmdt.dto.request.CartRequest;
import tmdtdemo.tmdt.dto.response.CartResponse;
import tmdtdemo.tmdt.service.CartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")

public class CartController {
    private final CartService cartService;
    @PostMapping ("/add")
    public ResponseEntity<CartResponse> addToCar(@RequestBody CartRequest cartRequest, HttpServletRequest httpServletRequest){
        CartResponse response = cartService.addToCard(cartRequest,httpServletRequest.getHeader("x-client-username"));
        return ResponseEntity.ok(response);
    }
    @PostMapping("/getByUsername")
    public ResponseEntity<CartResponse> get(HttpServletRequest httpServletRequest){
        CartResponse response = cartService.getByUsername(httpServletRequest.getHeader("x-client-username"));
        return ResponseEntity.ok(response);
    }
}
