import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IWorkgroup } from 'app/shared/model/SmartOrganizerMicro/workgroup.model';
import { WorkgroupService } from './workgroup.service';

@Component({
    selector: 'jhi-workgroup-update',
    templateUrl: './workgroup-update.component.html'
})
export class WorkgroupUpdateComponent implements OnInit {
    private _workgroup: IWorkgroup;
    isSaving: boolean;

    constructor(private workgroupService: WorkgroupService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ workgroup }) => {
            this.workgroup = workgroup;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.workgroup.id !== undefined) {
            this.subscribeToSaveResponse(this.workgroupService.update(this.workgroup));
        } else {
            this.subscribeToSaveResponse(this.workgroupService.create(this.workgroup));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IWorkgroup>>) {
        result.subscribe((res: HttpResponse<IWorkgroup>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get workgroup() {
        return this._workgroup;
    }

    set workgroup(workgroup: IWorkgroup) {
        this._workgroup = workgroup;
    }
}
