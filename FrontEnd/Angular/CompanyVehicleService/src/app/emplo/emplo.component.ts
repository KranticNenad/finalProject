import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-emplo',
  templateUrl: './emplo.component.html',
  styleUrls: ['./emplo.component.css']
})
export class EmploComponent implements OnInit {

  constructor(private http: HttpClient) { 
    console.log("SDADSADSA");
  }

  showEmployee(){
    this.http.get('http://localhost:8080/finalProject/employees').subscribe(data => {console.log("we got ", data)})
  }

  ngOnInit() {
    console.log("SDADSADSA");
    this.showEmployee();
  }

}

