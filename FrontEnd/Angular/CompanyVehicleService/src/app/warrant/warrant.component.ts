import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-warrant',
  templateUrl: './warrant.component.html',
  styleUrls: ['./warrant.component.css']
})
export class WarrantComponent implements OnInit {
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }

  private issueDate: string;
  private distance: number;
  private returnDate: string;
  private fuelUsed: number;
   
  constructor(issueDate: string,distance: number,returnDate:string,fuelUsed: number) {
      this.issueDate=issueDate;
      this.distance=distance;
      this.returnDate=returnDate;
      this.fuelUsed=fuelUsed;
  }
  
  public getIssueDate(): string {
      return this.issueDate;
  }
  public setIssueDate(issueDatearg:string) {
      this.issueDate=issueDatearg;
  }
  public getDistance(): number {
      return this.distance;
  }
  public setDistance(distancearg): void {
          this.distance=distancearg;
  }
  public getReturnDate(): string {
      return this.returnDate;
  }
  public setReturnDate(returnDatearg): void {
      this.returnDate=returnDatearg;
  }
  public getFuelUsed(): number {
      return this.fuelUsed;
  }
  public setFuelUsed(fuelUsedarg): void {
      this.fuelUsed=fuelUsedarg;
  }
}


