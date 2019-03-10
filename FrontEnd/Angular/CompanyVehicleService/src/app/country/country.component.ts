import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})

export class CountryComponent implements OnInit {
 
  private countryCode: string;    
  private name: string;  
  
  

  constructor(countryCode: string, name: string){

    this.countryCode=countryCode;
    this.name=name;
  }
 
  public getName(): string {
    return this.name;
  }
  public setNme(value: string) {
    this.name = value;
  }
  public getCountryCode(): string {
    return this.countryCode;
  }
  public setCountryCode(value: string) {
    this.countryCode = value;
  }

  ngOnInit() {
  }

}
