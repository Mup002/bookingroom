package tmdtdemo.tmdt.dto.response;

import lombok.Data;

@Data
public class ServiceResponse {
    private Long id;
    private String description;
    private String details;
    private Double price;
}
