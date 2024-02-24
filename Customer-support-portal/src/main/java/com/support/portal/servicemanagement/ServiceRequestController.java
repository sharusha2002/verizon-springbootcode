package com.support.portal.servicemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicerequests")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @Autowired
    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAllServiceRequests() {
        return serviceRequestService.getAllServiceRequests();
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestService.createServiceRequest(serviceRequest);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable Integer serviceId, @RequestBody ServiceRequest updatedServiceRequest) {
        return serviceRequestService.updateServiceRequest(serviceId, updatedServiceRequest);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable Integer serviceId) {
        return serviceRequestService.deleteServiceRequest(serviceId);
    }
}
