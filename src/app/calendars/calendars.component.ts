import { Component, OnInit } from '@angular/core';
import { CalendarDTO } from 'src/dto/calendardto';
import { CalendarService } from 'src/service/calendar.service';
import { EmployeeService } from 'src/service/employee.service';
import { EmployeeDTO } from 'src/dto/employeedto';
import { EmployeesComponent } from '../employees/employees.component';

@Component({
  selector: 'app-calendars',
  templateUrl: './calendars.component.html',
  styleUrls: ['./calendars.component.css']
})
export class CalendarsComponent implements OnInit {

  calendars: CalendarDTO[];
  calendartoinsert: CalendarDTO = new CalendarDTO();
  employees: EmployeeDTO[];
  constructor(private service: CalendarService, private empser: EmployeeService) { }

  ngOnInit() {
    this.getCalendars();
    this.empser.getAll().subscribe(employees => this.employees = employees);
    
  }
  
  getCalendars(){
    this.service.getAll().subscribe(calendars => this.calendars = calendars);
  }

  delete(calendar: CalendarDTO){
    this.service.delete(calendar.id).subscribe(() => this.getCalendars());
  }

  update(calendar: CalendarDTO){
    this.service.update(calendar).subscribe(() => this.getCalendars());
  }

  insert(calendar: CalendarDTO){
    this.service.insert(calendar).subscribe(() => this.getCalendars());
  }

  clear(){
    this.calendartoinsert = new CalendarDTO();
  }

  

}
