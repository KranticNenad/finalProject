import { Employee } from './employee.interface';
import { EmployeeService } from './employee.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
    
    employees: Employee[];
    employee1: Employee;
    employee2: Employee = {employeeId:123, name:"Tamir", surname:"Abdelmalek", dob: new Date(1750,11,25), salary: 4325.23, about: "I AM THE BEST TECH"};

    public constructor(private employeeService: EmployeeService) {
    }

    post(){
      this.employeeService.postEmployee(this.employee2).subscribe(employee => this.employee1);
    }

    delete(){
      this.employeeService
    }

    ngOnInit() {
      this.employeeService.getEmployees().subscribe(data => this.employees = data);
      this.employeeService.getEmployee(34523).subscribe(data => this.employee1 = data);
    }
  
}

