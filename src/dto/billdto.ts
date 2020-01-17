import { LocationDTO } from './locationdto';

export class BillDTO {

    id: number;
 
    customer: string;
 
    date: Date;
 
    location: LocationDTO = new LocationDTO();
 
    position: string;
 
    numberbill: number;
 
    price: number;
 
 }