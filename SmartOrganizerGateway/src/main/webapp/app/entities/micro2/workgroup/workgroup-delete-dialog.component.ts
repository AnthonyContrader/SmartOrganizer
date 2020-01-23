import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWorkgroup } from 'app/shared/model/micro2/workgroup.model';
import { WorkgroupService } from './workgroup.service';

@Component({
    selector: 'jhi-workgroup-delete-dialog',
    templateUrl: './workgroup-delete-dialog.component.html'
})
export class WorkgroupDeleteDialogComponent {
    workgroup: IWorkgroup;

    constructor(private workgroupService: WorkgroupService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.workgroupService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'workgroupListModification',
                content: 'Deleted an workgroup'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-workgroup-delete-popup',
    template: ''
})
export class WorkgroupDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ workgroup }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(WorkgroupDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.workgroup = workgroup;
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
