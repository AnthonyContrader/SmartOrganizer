import { Component, OnInit } from '@angular/core';
import { BillDTO } from 'src/dto/billdto';
import { BillService } from 'src/service/bill.service';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {

  bills: BillDTO[];
  billtoinsert: BillDTO = new BillDTO();

  constructor(private service: BillService) { }

  ngOnInit() {
    this.getBills();
  
  }

  getBills() {
    this.service.getAll().subscribe(bills => this.bills = bills);
  }

  delete(bill: BillDTO) {
    this.service.delete(bill.idbill).subscribe(() => this.getBills());
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
