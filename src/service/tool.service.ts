import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ToolDTO } from 'src/dto/tooldto';
import { HttpClient } from '@angular/common/http';
import {UserDTO} from'src/dto/userdto';
import { from } from 'rxjs';
import { AbstractServiceTool } from './abstracttoolsservice';
import { tap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class ToolService extends AbstractServiceTool<ToolDTO>{

  public first: string = "";
  public prev: string = "";
  public next: string = "";
  public last: string = "";

    constructor(httpClient: HttpClient){
        super(httpClient);
        this.type = 'tools';
        this.name = 'micro2';
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
         return this.httpClient.get('http://localhost:8080/api/users/' + username, {
           headers: {
             Authorization: this.auth()
           }
         });
        }

        public getFirstPage(){


          return this.httpClient.get<ToolDTO[]>(`${this.apiURL}/tool?page=1`,{ observe: 'response' }).pipe(tap(res => {
            const Link  = this.parse_link_header(res.headers.get('Link'));
            this.first  = Link["first"];
            this.last   = Link["last"];
            this.prev   = Link["prev"];
            this.next   = Link["next"];
    
          }));      
    
      }
      parse_link_header(header) {
        if (header.length == 0) {
          return ;
        }
    
        let parts = header.split(',');
        var links = {};
        parts.forEach( p => {
          let section = p.split(';');
          var url = section[0].replace(/<(.*)>/, '$1').trim();
          var name = section[1].replace(/rel="(.*)"/, '$1').trim();
          links[name] = url;
    
        });
        return links;
      }  

      public getNextPage(url: string){

        return this.httpClient.get<ToolDTO[]>(url,{ observe: 'response' }).pipe(tap(res => {
          const Link  = this.parse_link_header(res.headers.get('Link'));
          this.first  = Link["first"];
          this.last   = Link["last"];
          this.prev   = Link["prev"];
          this.next   = Link["next"];       
        }));      
   }

        

        
    
      
    
}