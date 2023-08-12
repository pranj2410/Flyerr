import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-create',
  templateUrl: './flight-create.component.html',
  styleUrls: ['./flight-create.component.css']
})
export class FlightCreateComponent {
  flightForm: Flight = {
    id:0,
	  flightName:'',
	  source:'',
	  destination:'',
	  price:0
  }

  constructor(
    private flightService: FlightService, 
    private router : Router
  ) {}

  ngOnInit(): void {}

  create(){
    this.flightService.createFlight(this.flightForm).subscribe({
      next: (data) => {
        this.router.navigate(["/flight"])
      },
      error: (err) => {
        console.log(err);
        
      }
    })
  }


}
