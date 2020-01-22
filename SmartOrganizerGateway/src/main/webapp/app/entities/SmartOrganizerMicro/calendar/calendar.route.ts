import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Calendar } from 'app/shared/model/SmartOrganizerMicro/calendar.model';
import { CalendarService } from './calendar.service';
import { CalendarComponent } from './calendar.component';
import { CalendarDetailComponent } from './calendar-detail.component';
import { CalendarUpdateComponent } from './calendar-update.component';
import { CalendarDeletePopupComponent } from './calendar-delete-dialog.component';
import { ICalendar } from 'app/shared/model/SmartOrganizerMicro/calendar.model';

@Injectable({ providedIn: 'root' })
export class CalendarResolve implements Resolve<ICalendar> {
    constructor(private service: CalendarService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((calendar: HttpResponse<Calendar>) => calendar.body));
        }
        return of(new Calendar());
    }
}

export const calendarRoute: Routes = [
    {
        path: 'calendar',
        component: CalendarComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Calendars'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'calendar/:id/view',
        component: CalendarDetailComponent,
        resolve: {
            calendar: CalendarResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Calendars'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'calendar/new',
        component: CalendarUpdateComponent,
        resolve: {
            calendar: CalendarResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Calendars'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'calendar/:id/edit',
        component: CalendarUpdateComponent,
        resolve: {
            calendar: CalendarResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Calendars'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const calendarPopupRoute: Routes = [
    {
        path: 'calendar/:id/delete',
        component: CalendarDeletePopupComponent,
        resolve: {
            calendar: CalendarResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Calendars'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
