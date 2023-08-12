import { Component } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent {
  public flights: Flight[] | any;
  todaydate = new Date();
  filterString='';
  constructor(
    // private route : ActivatedRoute,
    // private router : Router,
    private flightService : FlightService
  ){}
  
  deleteModal: any;
  ngOnInit(){
    this.flightService.getAllFlights().subscribe((res : Flight[]) => {
      this.flights = res;
      console.log(res);
    })
  }

  idTodelete:number=0; 
  allFlights:Flight[]=[]; 

  delete(delid: number){
    console.log("Delete");

    this.flightService.delete(delid).subscribe({
      next:(data) => {
        this.allFlights = this.allFlights.filter(_=>_.id!=delid)
        this.ngOnInit();
      },

      error:(err)=>{
        console.log(err);
        
      }
    })
    
  }
   

}
