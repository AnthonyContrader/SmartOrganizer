import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CalendarDTO } from 'src/dto/calendardto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CalendarService extends AbstractService<CalendarDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'calendar';
  }
}
