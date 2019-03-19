import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car.interface';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms'
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
  cars: Car[];

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
    model: new FormControl(''),
    isInUse: new FormControl('')
  });
   public constructor(private carService: CarService,private checkService: CheckService) {}

ngOnInit() {
  this.checkService.getStatus().subscribe(data => { 
    console.log(data);
    this.login = data;
});
      setTimeout(()=>{
            this.printData();             
      },
    100)

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
      let regNo = this.addCarForm.get('registration').value;
      let travelledKm = this.addCarForm.get('travelledKm').value;
      let avgFuelUser = this.addCarForm.get('avgFuelUse').value;
      let model = this.addCarForm.get('model').value;
      let isInUse = false;
      
      let carToAdd : Car = {regNo:regNo, travelledKm:travelledKm, avgFuelUse:avgFuelUser,model:model,isInUse:isInUse};
      this.carService.postCar(carToAdd).subscribe(() => this.cars.push(carToAdd));
      this.visible=false;
      }

      clickedOnCar(car:Car){
        this.editCarForm.setValue({registration: car.regNo, travelledKm: car.travelledKm,
        avgFuelUse: car.avgFuelUse, model: car.model, isInUse: car.isInUse});
      }

      public editCarFormMethod(): void {
        let regNo = this.editCarForm.get('registration').value;
        let travelledKm = this.editCarForm.get('travelledKm').value;
        let avgFuelUse = this.editCarForm.get('avgFuelUse').value;
        let model = this.editCarForm.get('model').value;
        let isInUse = this.editCarForm.get('isInUse').value;

        let carToEdit : Car = {regNo : regNo, travelledKm: travelledKm, avgFuelUse: avgFuelUse,
        model:model, isInUse:isInUse};

        this.carService.putCar(carToEdit).subscribe();
        this.cars[this.cars.findIndex(Car => Car.regNo == carToEdit.regNo)] = carToEdit;
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
      this.addCarForm.setValue({registration:'',travelledKm:'',avgFuelUse:'',model:''});
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

    makeVisible3(arg: any){
      this.visible3=true;
      this.argument=arg;
    }

    closeVisible3(){
      this.visible3=false;
    }

}



