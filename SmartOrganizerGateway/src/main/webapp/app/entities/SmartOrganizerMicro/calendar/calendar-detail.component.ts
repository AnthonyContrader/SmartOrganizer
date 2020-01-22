import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICalendar } from 'app/shared/model/SmartOrganizerMicro/calendar.model';

@Component({
    selector: 'jhi-calendar-detail',
    templateUrl: './calendar-detail.component.html'
})
export class CalendarDetailComponent implements OnInit {
    calendar: ICalendar;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ calendar }) => {
            this.calendar = calendar;
        });
    }

    previousState() {
        window.history.back();
    }
}
