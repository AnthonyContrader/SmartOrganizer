import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CalendarDTO } from 'src/dto/calendardto';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
  providedIn: 'root'
})
export class CalendarService extends AbstractService<CalendarDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'calendars';
    this.name = 'micro2';
    this.port = '8080'
  }

  auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;

    console.log(user.authorities + 'user');
    if (user) {
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }
  }

  userLogged(username: string) {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8080/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
    }
}
