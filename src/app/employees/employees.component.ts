import { Component, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/dto/employeedto';
import { EmployeeService } from 'src/service/employee.service';
import {WorkgroupDTO} from 'src/dto/workgroupdto';
import {WorkgroupService} from 'src/service/workgroup.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  employees: EmployeeDTO[];
  employeetoinsert: EmployeeDTO = new EmployeeDTO();
  workgroups: WorkgroupDTO[];

  constructor(private service: EmployeeService, private service2: WorkgroupService) { }

  ngOnInit() {
    this.getEmployees();
    this.service2.getAll().subscribe(workgroups => this.workgroups = workgroups);
  
  }

  getEmployees() {
    this.service.getAll().subscribe(employees => this.employees = employees);
  }

  delete(employee: EmployeeDTO) {
    this.service.delete(employee.id).subscribe(() => this.getEmployees());
  }

  update(employee: EmployeeDTO) {
    this.service.update(employee).subscribe(() => this.getEmployees());
  }

  insert(employee: EmployeeDTO) {
    this.service.insert(employee).subscribe(() => this.getEmployees());
  }

  clear(){
    this.employeetoinsert = new EmployeeDTO();
  }
}
