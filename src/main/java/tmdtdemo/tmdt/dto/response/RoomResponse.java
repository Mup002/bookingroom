package tmdtdemo.tmdt.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomResponse {
    private Long id;
    private String roomName;
    private Long number;
    private Long remainRoom;
    private String roomType;
    private String description;
    private List<String> item = new ArrayList<>();
    private String conditions;
    private boolean available;
    private List<ServiceResponse> serviceResponse;
}
