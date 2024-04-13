package tmdtdemo.tmdt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tmdtdemo.tmdt.dto.response.RoomResponse;
import tmdtdemo.tmdt.service.RoomService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/room")
public class RoomController {
    private final RoomService roomService;
    @GetMapping("/getAll")
    public ResponseEntity<List<RoomResponse>> getAllRoom(){
        List<RoomResponse> responses = roomService.getAllRoom();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
    @GetMapping("/getRoom/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable("id")Long id){
        RoomResponse response = roomService.getRoomById(id);
        return ResponseEntity.ok(response);
    }

}
