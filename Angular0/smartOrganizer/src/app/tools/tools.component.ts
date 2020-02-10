import { Component, OnInit } from '@angular/core';
import { ToolDTO } from 'src/dto/tooldto';
import { ToolService } from 'src/service/tool.service';
import { timer } from 'rxjs';
import { EmployeeDTO } from 'src/dto/employeedto';
import { EmployeeService } from 'src/service/employee.service';

@Component({
  selector: 'app-tools',
  templateUrl: './tools.component.html',
  styleUrls: ['./tools.component.css']
})
export class ToolsComponent implements OnInit {

  tools: ToolDTO[];
  tooltoinsert: ToolDTO = new ToolDTO();
  employees: EmployeeDTO[];

  constructor(private service: ToolService, private empser: EmployeeService) { }


  forzaavellino(){
    document.getElementById("usurato").setAttribute("style","visibility:visible");
  }

  ngOnInit() {
    this.getTools();
    this.empser.getAll().subscribe(employees => this.employees = employees);
  }

  getTools(){
    this.service.getAll().subscribe(tools => this.tools = tools);
  }

  delete(tool: ToolDTO){
    this.service.delete(tool.id).subscribe(() => this.getTools());
  }

  update(tool: ToolDTO){
    this.service.update(tool).subscribe(() => this.getTools());
  }

  insert(tool: ToolDTO){
    this.service.insert(tool).subscribe(() => this.getTools());
  }

 async usura(tool:ToolDTO){
    
for(var i=0; i<100;i++)
{
 // var life : number;
 // life=i;
  

    await new Promise(resolve => setTimeout(()=>resolve(), 500)).then(()=>this.service.usura(tool).subscribe(()=>this.getTools()));
    tool.lifetime = 100-i;
    
  }
  if (tool.lifetime==1){
    this.forzaavellino();
    
  }
}
 

  clear(){
    this.tooltoinsert = new ToolDTO();
  }

 
  

}
