package tmdtdemo.tmdt.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartResponse {
    private Long userId;
    private String createdAt;
    private Double total;
    private List<ServiceResponse> serviceResponses = new ArrayList<>();
    private String roomName;
    private Long roomId;
    private String checkIn;
    private String checkOut;
    private String time;
}
