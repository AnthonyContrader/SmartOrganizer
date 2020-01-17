import { Component, OnInit } from '@angular/core';
import { WorkgroupDTO } from 'src/dto/workgroupdto';
import { WorkgroupService } from 'src/service/workgroup.service';

@Component({
  selector: 'app-workgroup',
  templateUrl: './workgroup.component.html',
  styleUrls: ['./workgroup.component.css']
})
export class WorkgroupComponent implements OnInit {

  workgroups : WorkgroupDTO[];
  workgrouptoinsert : WorkgroupDTO=new WorkgroupDTO();
 
  constructor(private service: WorkgroupService) { }

  ngOnInit() {
    this.getWorkgroups();
  }

  getWorkgroups(){
    this.service.getAll().subscribe(workgroups => this.workgroups = workgroups)
  }

  delete(workgroup: WorkgroupDTO){
  this.service.delete(workgroup.id).subscribe(()=> this.getWorkgroups())
  }

  update(workgroup: WorkgroupDTO){
    this.service.update(workgroup).subscribe(()=> this.getWorkgroups())
  }

  insert(workgroup: WorkgroupDTO){
    this.service.insert(workgroup).subscribe(()=>this.getWorkgroups())
  }

  clear(){
    this.workgrouptoinsert= new WorkgroupDTO();
  }

}
