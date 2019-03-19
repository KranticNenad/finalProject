import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car.interface';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { CheckComponent } from '../check/check.component';
import { Login } from '../login/login.interface';
import { CheckService } from '../check.service';
import * as jsPDF from 'jspdf';
import 'jspdf-autotable';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  visible: boolean = false;
  visible2: boolean = false;
  visible3: boolean = false;
  argument: any='';
  searchVar: string='';
  disabledv = true;
  login: Login;

  public search(arg): void {
    this.searchVar=arg.target.value;
}

public show(arg:any): boolean {
 
  if(this.searchVar =='' || arg.regNo.startsWith(this.searchVar) ) {
    return true;
  }
  else {
  return false;     
}
}

  car: Car = {
    regNo: '',
    travelledKm: 0,
    avgFuelUse: 0,
    isInUse: false,
    model: ''
}
  addCarForm = new FormGroup({
    registration: new FormControl(''),
    travelledKm: new FormControl(''),
    avgFuelUse: new FormControl(''),
    model: new FormControl('')
  });

  editCarForm = new FormGroup({
    registration: new FormControl(''),
    travelledKm: new FormControl(''),
    avgFuelUse: new FormControl(''),
    model: new FormControl('')
  });

    cars: Car[];

   public constructor(private carService: CarService,private checkService: CheckService) {}

ngOnInit() {
  this.checkService.getStatus().subscribe(data => { 
    console.log(data);
    this.login = data;
});
      setTimeout(()=>{
            this.printData();             
      },
      2000)

  }

  saveAsPdf() {

    var doc = new jsPDF('l', 'mm', 'a4');
    let rows = [];

    this.cars.forEach(car => {
      rows.push([car.regNo, car.travelledKm, car.avgFuelUse, car.isInUse, car.model]);
    });

    doc.autoTable({
      head:[["Registration","TravelledKm","AvgFuelUse","IsInUse","Model"]],
      body:rows
    });
    doc.save("Cars.pdf");
  }

  public printData(): void {
    if(this.login.auth=='admin') {
      this.disabledv=false;
        this.carService.getCars().subscribe(data => this.cars = data);
      }
      else if(this.login.auth =='user') {
        this.disabledv=true;
        console.log(this.login.userName+ "OVO JE USERNAME");
        this.carService.getCars().subscribe(data => this.cars=data);
      }


    }

    public addCar(): void {

      console.log("CAR ADDED");
      this.car.regNo=this.addCarForm.get("registration").value;
      this.car.travelledKm=this.addCarForm.get("travelledKm").value
      this.car.avgFuelUse=this.addCarForm.get("avgFuelUse").value
      this.car.model=this.addCarForm.get("model").value
      this.car.isInUse=false;
      this.carService.postCar(this.car).subscribe(car =>
        this.car);
      this.cars.push(this.car);
      this.visible=false;
      console.log(this.car);
      }

      public editCarFormMethod(): void {

        this.car.regNo=this.argument.regNo;
        this.car.travelledKm=this.editCarForm.get("travelledKm").value;
        this.car.avgFuelUse=this.editCarForm.get("avgFuelUse").value;
        this.car.model=this.editCarForm.get("model").value;
        this.car.isInUse=false;
        console.log("THIS IS A CAR");
        console.log(this.car);
        this.carService.putCar(this.car).subscribe(data => this.car);
        for(let i=0;i<this.cars.length;i++) {
          if(this.cars[i].regNo==this.car.regNo) {
            this.cars[i]=this.car;
          }
        }
        console.log(this.cars.length);
        this.visible2=false;   
      }

        public deleteCar(): void {
          console.log("CAR DELETED");
          console.log(this.argument);
          this.carService.deleteCar(this.argument.regNo).subscribe(() =>
          console.log("DELETED"));
          for(let i=0;i<this.cars.length;i++) {
            if(this.argument.regNo==this.cars[i].regNo) {
              this.cars.splice(i,1);
              console.log(this.cars);
              break;
            }
          }
          this.visible3=false;           
        }

    makeVisible(){
      this.visible=true;
      for(let i=0;i<this.cars.length;i++) {
        console.log("USAO OVDE U PETLJU");
        console.log(this.cars[i]);
        this.cars[i].isInUse=true;
         }
    }

    closeVisible(){
      this.visible=false;
    }

    makeVisible2(arg: any ){
      this.visible2=true;
      this.argument=arg;
      this.editCarForm.setValue(
        {
          registration: arg.regNo,
          travelledKm: arg.travelledKm,
          avgFuelUse: arg.avgFuelUse,
          model: arg.model
        }
      );
      console.log(this.argument.regNo + "ARGUMENT");
    }

    closeVisible2(){
      this.visible2=false;
    }

    makeVisible3(arg: any){
      this.visible3=true;
      this.argument=arg;
    }

    closeVisible3(){
      this.visible3=false;
    }

}



