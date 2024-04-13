package tmdtdemo.tmdt.controller.test;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tmdtdemo.tmdt.dto.request.OrderRequest;
import tmdtdemo.tmdt.dto.response.OrderDetailsResponse;
import tmdtdemo.tmdt.dto.response.OrderResponse;
import tmdtdemo.tmdt.dto.response.RoomSkuResponse;
import tmdtdemo.tmdt.entity.RoomSku;
import tmdtdemo.tmdt.service.OrderService;
import tmdtdemo.tmdt.service.RoomService;
import tmdtdemo.tmdt.utils.AppConstants;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final OrderService orderService;
    private final RoomService roomService;
    @GetMapping("/index")
    public ResponseEntity<String> index(Principal principal){
        return ResponseEntity.ok("Welcome to admin page : " + principal.getName());
    }

    @PostMapping("/order/byAdminFor/{username}")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request,@PathVariable("username")String username){
        String rs = orderService.orderByAdmin(request,username);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/order/getAllByAdmin")
    public ResponseEntity<List<OrderResponse>> getAllOrderByAdmin(){
        List<OrderResponse> rs = orderService.getAllOrderByAdmin();
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/order/getOrderDetailById/{id}")
    public ResponseEntity<OrderDetailsResponse> getOrderDetail(@PathVariable("id")Long id){
        OrderDetailsResponse response = orderService.getOrderDetailsById(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/allRoomPages")
    public ResponseEntity<RoomSkuResponse> getAllRoomWithPagination(
            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize
    ){
        return ResponseEntity.ok(roomService.getAllRoomSkuWithPagination(pageNumber,pageSize));
    }
    @GetMapping("/allRoomPagesSort")
    public ResponseEntity<RoomSkuResponse> getAllRoomWithPaginationSorting(
            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize,
            @RequestParam(defaultValue = AppConstants.SORT_BY, required = false)String sortBy,
            @RequestParam(defaultValue = AppConstants.SORT_DIR, required = false) String dir
    ){
        return ResponseEntity.ok(roomService.getAllRoomSkuWithPaginationWithSoring(pageNumber,pageSize,sortBy,dir));
    }
}