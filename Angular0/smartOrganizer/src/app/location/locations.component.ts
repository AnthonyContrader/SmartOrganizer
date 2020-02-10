import { Component, OnInit } from '@angular/core';
import { LocationDTO } from 'src/dto/locationdto';
import { LocationService } from 'src/service/location.service';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {

  locations: LocationDTO[];
  locationtoinsert: LocationDTO = new LocationDTO();

  constructor(private service: LocationService) { }

  ngOnInit() {
    this.getLocations();
  }

  getLocations(){
    this.service.getAll().subscribe(locations => this.locations = locations);
  }

  delete(location: LocationDTO){
    this.service.delete(location.id).subscribe(() => this.getLocations());
  }

  update(location: LocationDTO){
    this.service.update(location).subscribe(() => this.getLocations());
  }

  insert(location: LocationDTO){
    this.service.insert(location).subscribe(() => this.getLocations());
  }

  clear(){
    this.locationtoinsert = new LocationDTO();
  }
}
