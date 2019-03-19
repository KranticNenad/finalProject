import { LocationService } from './../location/location.service';
import { Login } from './../login/login.interface';
import { CheckService } from './../check.service';
import { Employee } from './../employee/employee.interface';
import { CarService } from './../car/car.service';
import { Car } from './../car/car.interface';
import { Warrant } from './warrant.interface';
import { WarrantService } from './warrant.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import * as jsPDF from 'jspdf';
import 'jspdf-autotable';
import { WarrantDto } from './warrant-dto.interface';
import { EmployeeService } from '../employee/employee.service';
import { Location } from './../location/location.interface';

@Component({
  selector: 'app-warrant',
  templateUrl: './warrant.component.html',
  styleUrls: ['./warrant.component.css']
})
export class WarrantComponent implements OnInit {

  visible: boolean = false;
  visible2: boolean = false;
  visible3: boolean = false;
  visible4: boolean = false;
  clickedLocations: Location[];
  warrants: Warrant[];
  cars: Car[];
  employees: Employee[];
  locations: Location[];
  warrantToDelete: number;
  searchVar: string='';
  login :Login;
  name:string = '';

  public search(arg): void {
    this.searchVar=arg.target.value;
}

public show(arg:any): boolean {
 
  if(this.searchVar =='' || arg.warrantId.toString() == this.searchVar ) {
    return true;
  }
  else {
  return false;     
}
}
public constructor(private warrantService: WarrantService,
  private carService: CarService, private employeeService: EmployeeService,
  private checkService: CheckService, private locationService: LocationService){

}
addForm = new FormGroup({
  distance: new FormControl(''),
  fuelUsed: new FormControl(''),
  car: new FormControl(''),
  employee: new FormControl(''),
  user: new FormControl(''),
  location1: new FormControl(''),
  location2: new FormControl(''),
  location3: new FormControl(''),
  location4: new FormControl('')
});

editForm = new FormGroup({
  warrantId: new FormControl(''),
  issuedAt: new FormControl(''),
  distance: new FormControl(''),
  returnedAt: new FormControl(''),
  fuelUsed: new FormControl(''),
  car: new FormControl(''),
  employee: new FormControl(''),
  user: new FormControl(''),
  location1: new FormControl(''),
  location2: new FormControl(''),
  location3: new FormControl(''),
  location4: new FormControl('')
});

saveAsPdf() {

  var doc = new jsPDF('l', 'mm', 'a4');
  let rows = [];

  this.warrants.forEach(warrant => {
    let locations : string = "";
    let issuedAtString : string = new Date(warrant.issuedAt).getDate() + '/' + (new Date(warrant.issuedAt).getMonth() + 1) + '/' + new Date(warrant.issuedAt).getFullYear();
    let returnedAtString : string = new Date(warrant.returnedAt).getDate() + '/' + (new Date(warrant.returnedAt).getMonth() + 1) + '/' + new Date(warrant.returnedAt).getFullYear();
    warrant.locations.forEach(location => locations += location.name + " ");
    locations = locations.trim();
    locations = locations.replace(' ',', ');
    rows.push([warrant.warrantId, 
      issuedAtString, warrant.distance, warrant.returnedAt?returnedAtString:"",
      warrant.fuelUsed, warrant.car.regNo + " " + warrant.car.model,
      warrant.employee.name + " " + warrant.employee.surname, warrant.user.username, locations]);
  });

  doc.autoTable({
    head:[["WarrantId","IssuedAt","Distance","ReturnedAt","FuelUsed","Car","Employee","User","Locations"]],
    body:rows
  });
  doc.save("Warrants.pdf");
}

setClickedLocations(locations: Location[]){
  this.clickedLocations = locations;
}

clickedOnAdd(){
  this.carService.getCars().subscribe(data => this.cars = data.filter(Car => !Car.isInUse && Car.travelledKm < 300000.0));
  this.employeeService.getEmployees().subscribe(data => this.employees = data);
  this.locationService.getLocations().subscribe(data => this.locations = data);
  this.addForm.patchValue({user:this.checkService.login.userName});
}

clickedOnWarrant(warrant:Warrant){
  this.carService.getCars().subscribe(data => this.cars = data.filter(Car => !Car.isInUse && Car.travelledKm < 300000.0));
  this.employeeService.getEmployees().subscribe(data => this.employees = data);
  this.locationService.getLocations().subscribe(data => this.locations = data);
  let issuedAtString : string = new Date(warrant.issuedAt).getDate() + '/' + (new Date(warrant.issuedAt).getMonth() + 1) + '/' + new Date(warrant.issuedAt).getFullYear();
  let returnedAtString : string = new Date(warrant.returnedAt).getDate() + '/' + (new Date(warrant.returnedAt).getMonth() + 1) + '/' + new Date(warrant.returnedAt).getFullYear();
  this.editForm.setValue({warrantId: warrant.warrantId, 
    issuedAt: issuedAtString, distance: warrant.distance, 
    returnedAt: warrant.returnedAt?returnedAtString:"",
    fuelUsed: warrant.fuelUsed, car: warrant.car.regNo,
    employee:warrant.employee.employeeId, user: warrant.user.username,
    location1: warrant.locations[0]?warrant.locations[0].locationCode:"",
     location2:warrant.locations[1]?warrant.locations[1].locationCode:"",
     location3:warrant.locations[2]?warrant.locations[2].locationCode:"",
    location4:warrant.locations[3]?warrant.locations[3].locationCode:""});
}

addWarrant() {
  let distance : number = this.addForm.get('distance').value;
  let fuelUsed : number = this.addForm.get('fuelUsed').value;
  let regNo  : string = this.addForm.get('car').value;
  let employeeId : number = this.addForm.get('employee').value;
  let username: string = this.addForm.get('user').value;
  let locationCodes: string[] = [];
  if (this.addForm.get('location1').value != ""){
    locationCodes.push(this.addForm.get('location1').value)
  }
  if (this.addForm.get('location2').value != ""){
    locationCodes.push(this.addForm.get('location2').value)
  }
  if (this.addForm.get('location3').value != ""){
    locationCodes.push(this.addForm.get('location3').value)
  }
  if (this.addForm.get('location4').value != ""){
    locationCodes.push(this.addForm.get('location4').value)
  }

  let warrantToAdd : WarrantDto = {warrantId:0, issuedAt:new Date(0),
    distance: distance, returnedAt: null,
    fuelUsed:fuelUsed, regNo:regNo, employeeId:employeeId,
    username:username, locationCodes:locationCodes};

  this.warrantService.postWarrant(warrantToAdd).subscribe(response => {
    response.issuedAt = new Date();
    this.warrants.push(response);
    response.car.travelledKm += response.distance;
    response.car.isInUse = true;
    this.carService.putCar(response.car).subscribe();
  });
  
  this.visible = false;
}

editWarrant() {
  let warrantId : number = this.editForm.get('warrantId').value;

  let issuedAtString : string = this.editForm.get('issuedAt').value;
  let year : number = parseInt (issuedAtString.split('/')[2]);
  let month : number = parseInt (issuedAtString.split('/')[1]) - 1;
  let day : number = parseInt (issuedAtString.split('/')[0]);
  let issuedAt : Date = new Date(year, month, day);

  let distance : number = this.editForm.get('distance').value;

  let returnedAtString : string = this.editForm.get('returnedAt').value;
  let year2 : number = parseInt (returnedAtString.split('/')[2]);
  let month2 : number = parseInt (returnedAtString.split('/')[1]) - 1;
  let day2 : number = parseInt (returnedAtString.split('/')[0]);
  let returnedAt : Date = new Date(year2, month2, day2);

  let fuelUsed : number = this.editForm.get('fuelUsed').value;
  let regNo  : string = this.editForm.get('car').value;
  let employeeId : number = this.editForm.get('employee').value;
  let username: string = this.editForm.get('user').value;
  let locationCodes: string[] = [];
  if (this.editForm.get('location1').value != ""){
    locationCodes.push(this.editForm.get('location1').value)
  }
  if (this.editForm.get('location2').value != ""){
    locationCodes.push(this.editForm.get('location2').value)
  }
  if (this.editForm.get('location3').value != ""){
    locationCodes.push(this.editForm.get('location3').value)
  }
  if (this.editForm.get('location4').value != ""){
    locationCodes.push(this.editForm.get('location4').value)
  }

  let warrantToEdit : WarrantDto = {warrantId:warrantId, issuedAt: issuedAt,
    distance: distance, returnedAt:returnedAt,
    fuelUsed:fuelUsed, regNo:regNo, employeeId:employeeId,
    username:username, locationCodes:locationCodes};

  this.warrantService.putWarrant(warrantToEdit).subscribe(response => {
    this.warrants[this.warrants.findIndex(Warrant => Warrant.warrantId == response.warrantId)] = response;
    if (response.returnedAt){
      response.car.isInUse = false;
      this.carService.putCar(response.car).subscribe();
    }
  });
  this.visible2 = false;
}

setWarrantDelete(warrantId : number){
  this.warrantToDelete = warrantId;
}

deleteWarrant(){
  this.warrantService.deleteWarrant(this.warrantToDelete).subscribe();
  this.warrants = this.warrants.filter(Warrant => Warrant.warrantId != this.warrantToDelete);
  this.visible3 = false;
}


  makeVisible(){
    this.addForm.setValue({distance:'',fuelUsed:'',car:'',employee:'',user:'',location1:'',location2:'',location3:'',location4:''});
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

  makeVisible4(){
    this.visible4=true;
  }

  closeVisible4(){
    this.visible4=false;
  }

  ngOnInit() {
    this.warrantService.getWarrants().subscribe(data => this.warrants = data);
    
  }
}

