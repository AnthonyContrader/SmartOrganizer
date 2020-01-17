import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { LocationDTO } from 'src/dto/locationdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class LocationService extends AbstractService<LocationDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'location';
    }
}