import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { EmployeeDTO } from 'src/dto/employeedto';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService extends AbstractService<EmployeeDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'employee';
  }
}