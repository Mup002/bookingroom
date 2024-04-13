package tmdtdemo.tmdt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tmdtdemo.tmdt.dto.response.ServiceResponse;
import tmdtdemo.tmdt.service.ServiceService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/service")
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceResponse>> getAllService(){
        List<ServiceResponse> responses = serviceService.getAll();
        return ResponseEntity.ok(responses);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ServiceResponse> getService(@PathVariable("id")Long id){
        ServiceResponse response = serviceService.getServiceById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getAllServiceByRoom/{id}")
    public ResponseEntity<List<ServiceResponse>> getListService(@PathVariable("id")Long id){
        List<ServiceResponse> responses = serviceService.getAllServiceByRoom(id);
        return ResponseEntity.ok(responses);
    }
}
