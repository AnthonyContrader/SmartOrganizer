import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ToolDTO } from 'src/dto/tooldto';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ToolService extends AbstractService<ToolDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'tool';
    }
}