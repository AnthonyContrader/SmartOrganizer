import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICalendar } from 'app/shared/model/SmartOrganizerMicro/calendar.model';
import { CalendarService } from './calendar.service';

@Component({
    selector: 'jhi-calendar-delete-dialog',
    templateUrl: './calendar-delete-dialog.component.html'
})
export class CalendarDeleteDialogComponent {
    calendar: ICalendar;

    constructor(private calendarService: CalendarService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.calendarService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'calendarListModification',
                content: 'Deleted an calendar'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-calendar-delete-popup',
    template: ''
})
export class CalendarDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ calendar }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(CalendarDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.calendar = calendar;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
