import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car.interface';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';


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

   public constructor(private carService: CarService) {}

ngOnInit() {
        this.carService.getCars().subscribe(data => this.cars = data);
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
      this.car.travelledKm=this.editCarForm.get("travelledKm").value
      this.car.avgFuelUse=this.editCarForm.get("avgFuelUse").value
      this.car.model=this.editCarForm.get("model").value
      this.carService.putCar(this.car).subscribe(()=> {console.log("cao")});
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
    }

    closeVisible(){
      this.visible=false;
    }

    makeVisible2(arg: any ){
      this.visible2=true;
      this.argument=arg;
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



