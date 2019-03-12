import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car.interface';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

    cars: Car[];

   public constructor(private carService: CarService) {}

ngOnInit() {
        this.carService.getCars().subscribe(data => this.cars = data);
    }

}



