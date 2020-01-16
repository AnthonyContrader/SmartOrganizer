import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { BillDTO } from 'src/dto/billdto';

@Injectable({
  providedIn: 'root'
})
export class BillService extends AbstractService<BillDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'bill';
  }
}