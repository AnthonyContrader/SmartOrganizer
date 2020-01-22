import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SmartOrganizerGatewaySharedModule } from 'app/shared';
import {
    WorkgroupComponent,
    WorkgroupDetailComponent,
    WorkgroupUpdateComponent,
    WorkgroupDeletePopupComponent,
    WorkgroupDeleteDialogComponent,
    workgroupRoute,
    workgroupPopupRoute
} from './';

const ENTITY_STATES = [...workgroupRoute, ...workgroupPopupRoute];

@NgModule({
    imports: [SmartOrganizerGatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        WorkgroupComponent,
        WorkgroupDetailComponent,
        WorkgroupUpdateComponent,
        WorkgroupDeleteDialogComponent,
        WorkgroupDeletePopupComponent
    ],
    entryComponents: [WorkgroupComponent, WorkgroupUpdateComponent, WorkgroupDeleteDialogComponent, WorkgroupDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SmartOrganizerGatewayWorkgroupModule {}
