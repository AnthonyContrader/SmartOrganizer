import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { EmployeesComponent } from '../employees/employees.component';
import { ToolsComponent } from '../tools/tools.component';
import {LocationsComponent} from'../location/locations.component';
import { BillsComponent } from '../bills/bills.component';
import { CalendarsComponent } from '../calendars/calendars.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, EmployeesComponent, ToolsComponent, LocationsComponent, BillsComponent, CalendarsComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
