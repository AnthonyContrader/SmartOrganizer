import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ICalendar } from 'app/shared/model/SmartOrganizerMicro/calendar.model';
import { CalendarService } from './calendar.service';
import { IEmployee } from 'app/shared/model/SmartOrganizerMicro/employee.model';
import { EmployeeService } from 'app/entities/SmartOrganizerMicro/employee';

@Component({
    selector: 'jhi-calendar-update',
    templateUrl: './calendar-update.component.html'
})
export class CalendarUpdateComponent implements OnInit {
    private _calendar: ICalendar;
    isSaving: boolean;

    employees: IEmployee[];
    dateDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private calendarService: CalendarService,
        private employeeService: EmployeeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ calendar }) => {
            this.calendar = calendar;
        });
        this.employeeService.query({ filter: 'calendar-is-null' }).subscribe(
            (res: HttpResponse<IEmployee[]>) => {
                if (!this.calendar.employeeId) {
                    this.employees = res.body;
                } else {
                    this.employeeService.find(this.calendar.employeeId).subscribe(
                        (subRes: HttpResponse<IEmployee>) => {
                            this.employees = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.calendar.id !== undefined) {
            this.subscribeToSaveResponse(this.calendarService.update(this.calendar));
        } else {
            this.subscribeToSaveResponse(this.calendarService.create(this.calendar));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ICalendar>>) {
        result.subscribe((res: HttpResponse<ICalendar>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackEmployeeById(index: number, item: IEmployee) {
        return item.id;
    }
    get calendar() {
        return this._calendar;
    }

    set calendar(calendar: ICalendar) {
        this._calendar = calendar;
    }
}
