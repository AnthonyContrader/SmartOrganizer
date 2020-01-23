import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IWorkgroup } from 'app/shared/model/micro2/workgroup.model';

@Component({
    selector: 'jhi-workgroup-detail',
    templateUrl: './workgroup-detail.component.html'
})
export class WorkgroupDetailComponent implements OnInit {
    workgroup: IWorkgroup;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ workgroup }) => {
            this.workgroup = workgroup;
        });
    }

    previousState() {
        window.history.back();
    }
}
