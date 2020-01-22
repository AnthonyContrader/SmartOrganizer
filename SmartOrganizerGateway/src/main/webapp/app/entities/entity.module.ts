import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SmartOrganizerGatewayEmployeeModule as SmartOrganizerMicroEmployeeModule } from './SmartOrganizerMicro/employee/employee.module';
import { SmartOrganizerGatewayWorkgroupModule as SmartOrganizerMicroWorkgroupModule } from './SmartOrganizerMicro/workgroup/workgroup.module';
import { SmartOrganizerGatewayCalendarModule as SmartOrganizerMicroCalendarModule } from './SmartOrganizerMicro/calendar/calendar.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        SmartOrganizerMicroEmployeeModule,
        SmartOrganizerMicroWorkgroupModule,
        SmartOrganizerMicroCalendarModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SmartOrganizerGatewayEntityModule {}
