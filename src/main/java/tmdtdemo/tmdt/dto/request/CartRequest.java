package tmdtdemo.tmdt.dto.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CardRequest {
    private Long userId;
    private Long roomId;
    private List<Long> serviceIds = new ArrayList<>();
    private String checkIn;
    private String checkOut;
    private String roomName;
}
