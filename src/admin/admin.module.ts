import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { EmployeesComponent } from 'src/app/employees/employees.component';
import { ToolsComponent } from 'src/app/tools/tools.component';
import { LocationsComponent } from 'src/app/location/locations.component';
import { BillsComponent } from 'src/app/bills/bills.component';
import { CalendarsComponent } from 'src/app/calendars/calendars.component';
import { WorkgroupComponent } from 'src/app/workgroup/workgroup.component';
import{NgxPaginationModule} from 'ngx-pagination';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, EmployeesComponent, ToolsComponent, LocationsComponent, BillsComponent, CalendarsComponent,WorkgroupComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,NgxPaginationModule
  ]
})
export class AdminModule { }
