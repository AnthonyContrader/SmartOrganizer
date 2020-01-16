import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isEmployeeCollapsed = false;
  isToolCollapsed = false;
  isLocationCollapsed = false;
  isBillCollapsed = false;
  isCalendarCollapsed = false;
  isWorkgroupCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  employeecollapse() {
    if (this.isEmployeeCollapsed === false) {
      this.isEmployeeCollapsed = true;
    } else { this.isEmployeeCollapsed = false; }
  }
  
  toolscollapse() {
    if (this.isToolCollapsed === false) {
      this.isToolCollapsed = true;
    } else { this.isToolCollapsed = false; }
  }
  locationscollapse() {
    if (this.isLocationCollapsed === false) {
      this.isLocationCollapsed = true;
    } else { this.isLocationCollapsed = false; }
  }
  billscollapse() {
    if (this.isBillCollapsed === false) {
      this.isBillCollapsed = true;
    } else { this.isBillCollapsed = false; }
  }

  calendarscollapse(){
    if(this.isCalendarCollapsed === false) {
      this.isCalendarCollapsed = true;
    } else { this.isCalendarCollapsed = false; }
  }
  workgroupscollapse(){
    if(this.isWorkgroupCollapsed === false) {
      this.isWorkgroupCollapsed = true;
    } else { this.isWorkgroupCollapsed = false; }
  }
}
