import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';
import {Injectable} from '@angular/core';
import {tap} from 'rxjs/operators';
import { ServiceTool } from './servicetool';
import { PaginationService } from 'ngx-pagination';
import { URLSearchParams } from 'url';


/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */

export abstract class AbstractServiceTool<DTO> implements ServiceTool<DTO> {

    type: string;
    port: string;
    name: string;
    // url 
    apiURL: string = 'http://localhost:'

    // stringhe per la paginazione
    public first: string="first";
    public prev: string="prev";
    public next: string="next";
    public last: string="last";
    public numeropagina: number=0;
    public numeroelementi: number=50;
    public numeropaginetotale: number=1;
    public pagina: string='?page='+this.numeropagina;
    public elementi:string='&size='+this.numeroelementi;



    constructor(protected httpClient: HttpClient) {
    }

    auth() {
        const user = JSON.parse(localStorage.getItem('Autoken')) as UserDTO;
        if (user) {
          console.log('Bearer ' + user.authorities);
          return 'Bearer ' + user.authorities;
        } else {
          return '';
        }
    
      }
      getAll(): Observable<DTO[]> {
        return this.httpClient.get<DTO[]>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/' + this.type , {
          headers: {
            Authorization : this.auth()
            
            
          }
        });
      }

      getAllPageable(): Observable<DTO[]> {
       
       
       
       
        return this.httpClient.get<DTO[]>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/' + this.type + this.pagina + this.elementi,
        {
          headers: {
            Authorization : this.auth()
            
                  }
        });
          
        
          
        }
      
    

 
    
      read(id: number): Observable<DTO> {
        return this.httpClient.get<DTO>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/'  + this.type + id , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
    
      delete(id: number): Observable<DTO> {
        return this.httpClient.delete<DTO>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/' + this.type + '/' + id , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
    
      insert(dto: DTO): Observable<DTO> {
        return this.httpClient.post<DTO>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/' + this.type, dto , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
      

      //metodo da rivedere in quanto non fa il controllo sull'id
      update(dto: DTO): Observable<DTO> {
        return this.httpClient.put<DTO>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/' + this.type, dto , {
          headers: {
            Authorization : this.auth()
          }
        });
    
      }

      // questo metodo serve solo nel mio progetto per simulare l'usura degli strumenti
      usura(dto: DTO): Observable<DTO> {
        return this.httpClient.put<DTO>(this.apiURL + this.port + '/' + this.name + '/' + 'api' + '/' + this.type +"/usura", dto , {
          headers: {
            Authorization : this.auth()

          }
        });
      }
}