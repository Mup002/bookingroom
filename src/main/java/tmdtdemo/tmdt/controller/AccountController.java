package tmdtdemo.tmdt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdtdemo.tmdt.dto.request.UserRequest;
import tmdtdemo.tmdt.service.UserService;
import tmdtdemo.tmdt.utils.BaseResponse;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:5173/")
public class AccountController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(@RequestBody UserRequest dto){
        return ResponseEntity.ok(userService.register(dto));
    }
}
