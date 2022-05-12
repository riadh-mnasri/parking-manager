package com.wehightech.parking.controller;

import com.wehightech.parking.model.Parking;
import com.wehightech.parking.service.ParkingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
    public List<Parking> getParkings() {
        return parkingService.getParkings();
    }
}
