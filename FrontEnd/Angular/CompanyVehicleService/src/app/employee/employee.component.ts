import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
    
    private firstName: string;
    private lastName: string;
    private salary: number;
    private about: string;

    public constructor(firstName:string, lastName: string,salary: number,about: string) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
    }

    public getFirstname(): string {
        return this.firstName;
    }
    public setFirstname(firstNamearg:string): void {
            this.firstName=firstNamearg;    
    }
    public getLastname(): string {
        return this.lastName;
    }    
    public setLastname(lastNamearg:string): void {
           this.lastName=lastNamearg; 
    }
    public getSalary(): number {
        return this.salary;
    }
    public setSalary(salaryarg): void {
          this.salary=salaryarg;  
    }
    public getAbout(): string {
        return this.about;
    }
    public setAbout(aboutarg): void {
        this.about=aboutarg;
    }

    ngOnInit() {
    }
  
}

