import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car.interface';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  visible: boolean = false;
  visible2: boolean = false;
  visible3: boolean = false;


    cars: Car[];

   public constructor(private carService: CarService) {}

ngOnInit() {
        this.carService.getCars().subscribe(data => this.cars = data);
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



