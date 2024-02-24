package com.support.portal.servicemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.support.portal.User.User;
import com.support.portal.User.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;
    private final UserRepository userRepository;

    @Autowired
    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository, UserRepository userRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<ServiceRequest>> getAllServiceRequests() {
        List<ServiceRequest> serviceRequests = serviceRequestRepository.findAll();
        return new ResponseEntity<>(serviceRequests, HttpStatus.OK);
    }

    public ResponseEntity<ServiceRequest> createServiceRequest(ServiceRequest serviceRequest) {
        Optional<User> optionalUser = userRepository.findById(serviceRequest.getUser().getUserid());
        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
        serviceRequest.setUser(optionalUser.get());
        ServiceRequest savedServiceRequest = serviceRequestRepository.save(serviceRequest);
        return new ResponseEntity<>(savedServiceRequest, HttpStatus.CREATED);
    }

    public ResponseEntity<ServiceRequest> updateServiceRequest(Integer serviceId, ServiceRequest updatedServiceRequest) {
        Optional<ServiceRequest> optionalServiceRequest = serviceRequestRepository.findById(serviceId);
        if (optionalServiceRequest.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        ServiceRequest existingServiceRequest = optionalServiceRequest.get();
        existingServiceRequest.setCategory(updatedServiceRequest.getCategory());
        existingServiceRequest.setDescription(updatedServiceRequest.getDescription());
        existingServiceRequest.setPrioritylevel(updatedServiceRequest.getPrioritylevel());
        existingServiceRequest.setStatus(updatedServiceRequest.getStatus());
        existingServiceRequest.setDateCreated(updatedServiceRequest.getDateCreated());
        ServiceRequest savedServiceRequest = serviceRequestRepository.save(existingServiceRequest);
        return new ResponseEntity<>(savedServiceRequest, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteServiceRequest(Integer serviceId) {
        Optional<ServiceRequest> optionalServiceRequest = serviceRequestRepository.findById(serviceId);
        if (optionalServiceRequest.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        serviceRequestRepository.deleteById(serviceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
