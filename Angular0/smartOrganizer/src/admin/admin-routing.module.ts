import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { AdminLayoutComponent } from 'src/app/layout/admin-layout/admin-layout.component';
import { EmployeesComponent } from 'src/app/employees/employees.component';
import { ToolsComponent } from 'src/app/tools/tools.component';
import { LocationsComponent } from 'src/app/location/locations.component';
import { BillsComponent } from 'src/app/bills/bills.component';
import { CalendarsComponent } from 'src/app/calendars/calendars.component';
import { WorkgroupComponent } from 'src/app/workgroup/workgroup.component';


/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'employees', component: EmployeesComponent},
    { path: 'tools', component: ToolsComponent},
    {path: 'locations', component:LocationsComponent},
    { path: 'bills', component:BillsComponent},
    { path: 'calendars', component: CalendarsComponent},
    {path:'workgroups',component: WorkgroupComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }