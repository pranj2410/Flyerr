import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-edit',
  templateUrl: './flight-edit.component.html',
  styleUrls: ['./flight-edit.component.css']
})
export class FlightEditComponent {
  flightForm: Flight = {
    id:0,
	  flightName:'',
	  source:'',
	  destination:'',
	  price:0
  }

  constructor(
    private flightService: FlightService, 
    private router : Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() : void {
    this.route.paramMap.subscribe((param) => {
      var id = Number(param.get('id'));
      this.getById(id);
    });
  }

  getById(id: number) {
    this.flightService.getById(id).subscribe((data) => {
      console.log(data);
      this.flightForm = data;
      
    });
  }


  update() {
    this.flightService.update(this.flightForm).subscribe({
      next:(data) => {
        this.router.navigate(["/flight"]);
      },
      error:(err) => {
        console.log(err);
        
      }
    })
  }



}
