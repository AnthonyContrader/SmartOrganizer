import { Component, OnInit } from '@angular/core';
import { BillDTO } from 'src/dto/billdto';
import { BillService } from 'src/service/bill.service';
import { LocationDTO } from 'src/dto/locationdto';
import { LocationService } from 'src/service/location.service';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {

  bills: BillDTO[];
  billtoinsert: BillDTO = new BillDTO();
  locations: LocationDTO[];

  constructor(private service: BillService, private locser: LocationService) { }

  ngOnInit() {
    this.getBills();
    this.locser.getAll().subscribe(locations => this.locations = locations);
  
  }

  getBills() {
    this.service.getAll().subscribe(bills => this.bills = bills);
  }

  delete(bill: BillDTO) {
    this.service.delete(bill.id).subscribe(() => this.getBills());
  }

  update(bill: BillDTO) {
    this.service.update(bill).subscribe(() => this.getBills());
  }

  insert(bill: BillDTO) {
    this.service.insert(bill).subscribe(() => this.getBills());
  }

  clear(){
    this.billtoinsert = new BillDTO();
  }
}
