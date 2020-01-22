import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { EmployeeDTO } from 'src/dto/employeedto';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService extends AbstractService<EmployeeDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'employees';
    this.name = 'SmartOrganizerMicro';
    this.port = '8080';
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