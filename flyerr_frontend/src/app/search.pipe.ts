import { Pipe, PipeTransform } from '@angular/core';
import { Flight } from './flight';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(flights : Flight[], filterString:string) {
    console.log('Filter Pipe called!');

    if(flights.length === 0 || filterString === ''){
      return flights;
    }
    else{
      return flights.filter((emp) =>{ return emp.flightName.toLowerCase() === filterString.toLowerCase()})
    }
    
    
  }

}
