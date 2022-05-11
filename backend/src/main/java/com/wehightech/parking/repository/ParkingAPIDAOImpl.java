package com.wehightech.parking.repository;

import com.wehightech.parking.repository.dto.ReponseParkingAPIEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ParkingAPIDAOImpl implements ParkingAPIDAO {
    private static final String URL_API_OPEN_DATA = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_parkings-publics-nantes-disponibilites&q=&rows=-1&facet=grp_nom&facet=grp_statut";

    private RestTemplate restTemplate;

    public ParkingAPIDAOImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ReponseParkingAPIEntity getParkings() {
        return restTemplate.getForEntity(URL_API_OPEN_DATA, ReponseParkingAPIEntity.class).getBody();
    }
}
