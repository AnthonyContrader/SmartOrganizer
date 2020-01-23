import { Moment } from 'moment';

export interface ICalendar {
    id?: number;
    date?: Moment;
    checkin?: string;
    checkout?: string;
    employeeId?: number;
}

export class Calendar implements ICalendar {
    constructor(public id?: number, public date?: Moment, public checkin?: string, public checkout?: string, public employeeId?: number) {}
}
