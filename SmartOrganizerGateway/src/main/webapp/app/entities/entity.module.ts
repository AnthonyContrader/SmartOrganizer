import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SmartOrganizerGatewayEmployeeModule as SmartOrganizerMicroEmployeeModule } from './SmartOrganizerMicro/employee/employee.module';
import { SmartOrganizerGatewayWorkgroupModule as SmartOrganizerMicroWorkgroupModule } from './SmartOrganizerMicro/workgroup/workgroup.module';
import { SmartOrganizerGatewayCalendarModule as SmartOrganizerMicroCalendarModule } from './SmartOrganizerMicro/calendar/calendar.module';
import { SmartOrganizerGatewayWorkgroupModule as Micro2WorkgroupModule } from './micro2/workgroup/workgroup.module';
import { SmartOrganizerGatewayEmployeeModule as Micro2EmployeeModule } from './micro2/employee/employee.module';
import { SmartOrganizerGatewayCalendarModule as Micro2CalendarModule } from './micro2/calendar/calendar.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        SmartOrganizerMicroEmployeeModule,
        SmartOrganizerMicroWorkgroupModule,
        SmartOrganizerMicroCalendarModule,
        Micro2WorkgroupModule,
        Micro2EmployeeModule,
        Micro2CalendarModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SmartOrganizerGatewayEntityModule {}
