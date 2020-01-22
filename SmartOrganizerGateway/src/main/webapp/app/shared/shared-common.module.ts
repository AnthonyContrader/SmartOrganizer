import { NgModule } from '@angular/core';

import { SmartOrganizerGatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [SmartOrganizerGatewaySharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [SmartOrganizerGatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class SmartOrganizerGatewaySharedCommonModule {}
