import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Workgroup } from 'app/shared/model/micro2/workgroup.model';
import { WorkgroupService } from './workgroup.service';
import { WorkgroupComponent } from './workgroup.component';
import { WorkgroupDetailComponent } from './workgroup-detail.component';
import { WorkgroupUpdateComponent } from './workgroup-update.component';
import { WorkgroupDeletePopupComponent } from './workgroup-delete-dialog.component';
import { IWorkgroup } from 'app/shared/model/micro2/workgroup.model';

@Injectable({ providedIn: 'root' })
export class WorkgroupResolve implements Resolve<IWorkgroup> {
    constructor(private service: WorkgroupService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((workgroup: HttpResponse<Workgroup>) => workgroup.body));
        }
        return of(new Workgroup());
    }
}

export const workgroupRoute: Routes = [
    {
        path: 'workgroup',
        component: WorkgroupComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Workgroups'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'workgroup/:id/view',
        component: WorkgroupDetailComponent,
        resolve: {
            workgroup: WorkgroupResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Workgroups'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'workgroup/new',
        component: WorkgroupUpdateComponent,
        resolve: {
            workgroup: WorkgroupResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Workgroups'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'workgroup/:id/edit',
        component: WorkgroupUpdateComponent,
        resolve: {
            workgroup: WorkgroupResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Workgroups'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const workgroupPopupRoute: Routes = [
    {
        path: 'workgroup/:id/delete',
        component: WorkgroupDeletePopupComponent,
        resolve: {
            workgroup: WorkgroupResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Workgroups'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
