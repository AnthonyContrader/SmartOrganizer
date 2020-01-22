import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { WorkgroupDTO } from 'src/dto/workgroupdto';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
    providedIn: 'root'
})
export class WorkgroupService extends AbstractService<WorkgroupDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'workgroups';
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