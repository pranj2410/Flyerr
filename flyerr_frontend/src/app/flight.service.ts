import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{map, Observable} from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient) { }
  public getAllFlights() : Observable<Flight[]> {
    return this.http.get<Flight[]>(`http://localhost:9090/api/fly`);

    
  }

  createFlight(data:any){
    return this.http.post<any>("http://localhost:9090/api/flight", data)

    .pipe(map((res:any)=>{
      return res;
    }));
  }

  getById(id: number){
    return this.http.get<Flight>(`http://localhost:9090/api/flight/${id}`);
    console.log('');
  }

  update(payload:Flight){
    return this.http.put(`http://localhost:9090/api/flight/${payload.id}`, payload);
  }

  delete(id:number){
    return this.http.delete<Flight>(`http://localhost:9090/api/flight/${id}`);
  }

}
