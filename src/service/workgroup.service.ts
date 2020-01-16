import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { WorkgroupDTO } from 'src/dto/workgroupdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class WorkgroupService extends AbstractService<WorkgroupDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'workgroup';
    }
}