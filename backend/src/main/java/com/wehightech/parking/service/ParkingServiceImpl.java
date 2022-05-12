package com.wehightech.parking.service;

import com.wehightech.parking.model.Parking;
import com.wehightech.parking.repository.ParkingAPIDAO;
import com.wehightech.parking.repository.dto.RecordEntity;
import com.wehightech.parking.repository.dto.ReponseParkingAPIEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    private ParkingAPIDAO parkingAPIDAO;

    public ParkingServiceImpl(ParkingAPIDAO parkingAPIDAO) {
        this.parkingAPIDAO = parkingAPIDAO;
    }

    @Override
    public List<Parking> getParkings() {
        ReponseParkingAPIEntity reponse = parkingAPIDAO.getParkings();
        return convertToEntityToModel(reponse);
    }

    private List<Parking> convertToEntityToModel(ReponseParkingAPIEntity reponse) {
        List<Parking> resultat = new ArrayList<Parking>();
        for (RecordEntity record : reponse.getRecords()) {
            Parking parking = new Parking();
            parking.setId(record.getFields().getIdObj());
            parking.setName(record.getFields().getGrpNom());
            parking.setStatus(getStatusLabel(record));
            parking.setAvailablePlaceCount(record.getFields().getGrpDisponible());
            parking.setTotalPlaceCount(record.getFields().getGrpExploitation());
            parking.setUpdateTime(getUpdateTime(record));
            resultat.add(parking);
        }
        return resultat;
    }

    private String getUpdateTime(RecordEntity record) {
        OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
        OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
        return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute();
    }

    private String getStatusLabel(RecordEntity record) {
        switch (record.getFields().getGrpStatut()) {
            case "1": {
                return "CLOSED";
            }
            case "2": {
                return "SUBSCRIBERS";
            }
            case "5": {
                return "OPEN";
            }
        }
        return "Data Not available";
    }
}
