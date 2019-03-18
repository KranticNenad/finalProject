import { Employee } from './employee.interface';
import { EmployeeService } from './employee.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import * as jsPDF from 'jspdf';
import 'jspdf-autotable';
import { CheckService } from '../check.service';
import { Login } from '../login/login.interface';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  public constructor(private employeeService: EmployeeService,private checkService: CheckService) {
  }

    visible: boolean = false;
    visible2: boolean = false;
    visible3: boolean = false;
    searchVar: string='';
    login: Login;

  public search(arg): void {
    this.searchVar=arg.target.value;
}

  public show(arg:any): boolean {
    
    if(this.searchVar =='' || arg.employeeId.toString()== this.searchVar  || arg.surname.toLowerCase().startsWith(this.searchVar.toLowerCase()) || arg.name.toLowerCase().startsWith(this.searchVar.toLowerCase()) || arg.salary.toString() ==this.searchVar)  {
    return true;
      }
    else {
      return false;     
        }
    }
   
    employees: Employee[];
    employeeToDelete: number;
    employee1: Employee;
    employee2: Employee = {employeeId:123, name:"Tamir", surname:"Abdelmalek", dob: new Date(1750,11,25), salary: 4325.23, about: "I AM THE BEST TECH"};

    

    addForm = new FormGroup({
      employeeId: new FormControl(''),
      name: new FormControl(''),
      surname: new FormControl(''),
      dob: new FormControl(''),
      salary: new FormControl('')
    });
    editForm = new FormGroup({
      employeeId: new FormControl(''),
      name: new FormControl(''),
      surname: new FormControl(''),
      dob: new FormControl(''),
      salary: new FormControl('')
    });

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

  addEmployee() {
    let id : number = this.addForm.get('employeeId').value;
    let name : string = this.addForm.get('name').value;
    let surname : string = this.addForm.get('surname').value;

    let dobString : string = this.addForm.get('dob').value;
    let year : number = parseInt (dobString.split('/')[2]);
    let month : number = parseInt (dobString.split('/')[1]) - 1;
    let day : number = parseInt (dobString.split('/')[0]);
    let dob : Date = new Date(year, month, day);

    let salary: number = this.addForm.get('salary').value;

    let employeeToAdd : Employee = {employeeId:id, name: name, surname: surname, dob:dob, salary:salary, about: "Newly added"};

    this.employeeService.postEmployee(employeeToAdd).subscribe(employee => employeeToAdd);
    this.employees.push(employeeToAdd);
    this.visible = false;
  }

  clickedOnEmployee(employee:Employee){
    let dobString : string = new Date(employee.dob).getDate() + '/' + (new Date(employee.dob).getMonth() + 1) + '/' + new Date(employee.dob).getFullYear();
    this.editForm.setValue({employeeId: employee.employeeId, name: employee.name, surname: employee.surname, dob: dobString, salary: employee.salary});
  }

  editEmployee(){
    let id : number = this.editForm.get('employeeId').value;
    let name : string = this.editForm.get('name').value;
    let surname : string = this.editForm.get('surname').value;

    let dobString : string = this.editForm.get('dob').value;
    let year : number = parseInt (dobString.split('/')[2]);
    let month : number = parseInt (dobString.split('/')[1]) - 1;
    let day : number = parseInt (dobString.split('/')[0]);
    let dob : Date = new Date(year, month, day);

    let salary: number = this.editForm.get('salary').value;

    let employeeToEdit : Employee = {employeeId:id, name: name, surname: surname, dob:dob, salary:salary, about: "Newly added"};

    this.employeeService.putEmployee(employeeToEdit).subscribe(employee => employeeToEdit);
    this.employees[this.employees.findIndex(Employee => Employee.employeeId == employeeToEdit.employeeId)] = employeeToEdit;
    this.visible2 = false;
  }

  setEmployeeDelete(employeeId : number){
    this.employeeToDelete = employeeId;
  }

  deleteEmployee(){
    this.employeeService.deleteEmployee(this.employeeToDelete).subscribe();
    this.employees = this.employees.filter(Employee => Employee.employeeId != this.employeeToDelete);
    this.visible3 = false;
  }

    post(){
      this.employeeService.postEmployee(this.employee2).subscribe(employee => this.employee1);
    }

    delete(){
      this.employeeService
    }

    salaryV: boolean=true;
    disabledv = true;

    ngOnInit() {
      this.checkService.getStatus().subscribe(login => this.login=login);
      this.employeeService.getEmployees().subscribe(data => this.employees = data);
      this.employeeService.getEmployee(34523).subscribe(data => this.employee1 = data);
      setTimeout(()=> 
      {
        if(this.login.auth=='user') {
          this.salaryV=false;
        }
        else {
          this.disabledv=false;
        }
      },1500);
    }

    makeVisible(){
      this.visible=true;
    }

    closeVisible(){
      this.visible=false;
    }

    makeVisible2(){
      this.visible2=true;
    }

    closeVisible2(){
      this.visible2=false;
    }

    makeVisible3(){
      this.visible3=true;
    }

    closeVisible3(){
      this.visible3=false;
    }
    
  
}

