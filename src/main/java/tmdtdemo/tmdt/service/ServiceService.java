package tmdtdemo.tmdt.service;

import tmdtdemo.tmdt.dto.response.ServiceResponse;

import java.util.List;

public interface ServiceService {
    List<ServiceResponse> getAll();
    ServiceResponse getServiceById(Long id);
    List<ServiceResponse> getAllServiceByRoom(Long id);
}
