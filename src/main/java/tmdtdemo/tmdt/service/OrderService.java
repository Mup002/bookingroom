package tmdtdemo.tmdt.service;


import tmdtdemo.tmdt.dto.request.OrderRequest;
import tmdtdemo.tmdt.dto.response.OrderDetailsResponse;
import tmdtdemo.tmdt.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    String orderByUser(OrderRequest request);
    String orderByAdmin(OrderRequest request,String username);
    List<OrderResponse> getAllOrderByAdmin();
    OrderDetailsResponse getOrderDetailsById(Long idOrder);
}
