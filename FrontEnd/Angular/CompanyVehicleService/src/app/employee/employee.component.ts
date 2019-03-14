import { Employee } from './employee.interface';
import { EmployeeService } from './employee.service';
import { Component, OnInit } from '@angular/core';
import * as jsPDF from 'jspdf';
import 'jspdf-autotable';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

    visible: boolean = false;
    validate: string = 'a';
    
    employees: Employee[];
    employee1: Employee;
    employee2: Employee = {employeeId:123, name:"Tamir", surname:"Abdelmalek", dob: new Date(1750,11,25), salary: 4325.23, about: "I AM THE BEST TECH"};

    public constructor(private employeeService: EmployeeService) {
    }

    saveAsPdf() {

      var doc = new jsPDF('l', 'mm', 'a4');
      let rows = [];
  
      this.employees.forEach(employee => {
        rows.push([employee.employeeId, employee.name, employee.surname, new Date(employee.dob).getDate() + "/" + new Date(employee.dob).getMonth() + "/" + new Date(employee.dob).getFullYear(), employee.salary]);
      });
  
      doc.autoTable({
        head:[["ID","Name","Surname","DOB","Salary"]],
        body:rows
      });
      doc.save("Employees.pdf");
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
      console.log(this.validate.length);
    }

    makeVisible(){
      this.visible=true;
    }

    closeVisible(){
      this.visible=false;
    }

    validateButton(){
      
    }
    
  
}

