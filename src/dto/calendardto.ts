import { EmployeeDTO } from './employeedto';

export class CalendarDTO{

    id: number;
    date: Date;
    checkin: string;
    checkout: string;
    employee: EmployeeDTO = new EmployeeDTO();
}