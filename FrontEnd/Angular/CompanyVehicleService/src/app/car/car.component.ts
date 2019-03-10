import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {
 
    private regno: string;
    private travelledKm: number;
    private avgFuelUse: number;
    private isInUse: boolean;
    private model: string;
    
    public constructor(regno:string,travelledKm:number,avgFuelUse: number,isInUse:boolean,model:string) {
            this.regno=regno;
            this.travelledKm=travelledKm;
            this.avgFuelUse=avgFuelUse;
            this.isInUse=isInUse;
            this.model=model;
    }

    public getRegNo(): string {
        return this.regno;
    }
    public setRegno(Regnoarg: string) {
        this.regno =Regnoarg ;
    }
    public getTravelledKm(): number {
        return this.travelledKm;
    }
    public setTravelledKm(travelledKmarg: number): void {
        this.travelledKm =travelledKmarg ;
    }
    public getAvgFuelUse(): number {
        return this.avgFuelUse;
    }
    public setAvgFuelUse(avgFuelUsearg: number): void {
        this.avgFuelUse =avgFuelUsearg;
    }

    public getIsInUse(): boolean {
        return this.isInUse;
    }
    public setIsInUse(isInUsearg): void {
         this.isInUse=isInUsearg; 
    }
    public getModel(): string {
        return this.model;
    }
    public setModel(modelarg:string): void {
            this.model=modelarg;
    }

    ngOnInit() {
    }
  
}
  


