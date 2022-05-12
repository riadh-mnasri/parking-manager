import { Injectable } from '@angular/core';
import { ParkingInfo } from './parkingInfo';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ParkingService {

  constructor(private httpClient : HttpClient) { }

  getParkings() : Observable<ParkingInfo[]> {
    return this.httpClient.get<ParkingInfo[]>(environment.apiUrl + '/parkings');
  }

  getParking(id: number) : Observable<ParkingInfo> {
    console.log("Parking id:", id)
    return this.httpClient.get<ParkingInfo[]>(environment.apiUrl + '/parkings').pipe(
      map(parkings => parkings.find(parking => parking.id == id))
    );
  }
}
