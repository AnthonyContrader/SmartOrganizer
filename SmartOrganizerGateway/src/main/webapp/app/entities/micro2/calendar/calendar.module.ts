import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SmartOrganizerGatewaySharedModule } from 'app/shared';
import {
    CalendarComponent,
    CalendarDetailComponent,
    CalendarUpdateComponent,
    CalendarDeletePopupComponent,
    CalendarDeleteDialogComponent,
    calendarRoute,
    calendarPopupRoute
} from './';

const ENTITY_STATES = [...calendarRoute, ...calendarPopupRoute];

@NgModule({
    imports: [SmartOrganizerGatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        CalendarComponent,
        CalendarDetailComponent,
        CalendarUpdateComponent,
        CalendarDeleteDialogComponent,
        CalendarDeletePopupComponent
    ],
    entryComponents: [CalendarComponent, CalendarUpdateComponent, CalendarDeleteDialogComponent, CalendarDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SmartOrganizerGatewayCalendarModule {}
