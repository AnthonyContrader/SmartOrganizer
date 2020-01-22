import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICalendar } from 'app/shared/model/SmartOrganizerMicro/calendar.model';

type EntityResponseType = HttpResponse<ICalendar>;
type EntityArrayResponseType = HttpResponse<ICalendar[]>;

@Injectable({ providedIn: 'root' })
export class CalendarService {
    private resourceUrl = SERVER_API_URL + 'smartorganizermicro/api/calendars';

    constructor(private http: HttpClient) {}

    create(calendar: ICalendar): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(calendar);
        return this.http
            .post<ICalendar>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(calendar: ICalendar): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(calendar);
        return this.http
            .put<ICalendar>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ICalendar>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ICalendar[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(calendar: ICalendar): ICalendar {
        const copy: ICalendar = Object.assign({}, calendar, {
            date: calendar.date != null && calendar.date.isValid() ? calendar.date.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.date = res.body.date != null ? moment(res.body.date) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((calendar: ICalendar) => {
            calendar.date = calendar.date != null ? moment(calendar.date) : null;
        });
        return res;
    }
}
