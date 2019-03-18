import { CheckService } from './check.service';
import { Component, OnInit } from '@angular/core';

import { Login } from './login/login.interface';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent implements OnInit {

  login: Login;
  name= '';
  visible: boolean=false;


  public constructor(private checkService: CheckService,private router: Router) {}

  ngOnInit() {
    this.checkService.getStatus().subscribe(data => this.login=data);
    setTimeout(()=> {
      if(this.login.status=='true') {
        this.visible=true;
      }
      else {
        this.visible=false;
      }
    },2000)

    this.checkService.subject.subscribe(
      data => {

        this.login=data;
        if(this.login.status=='true') {
          this.visible=true;
          this.name=this.login.userName;
        }
        else {
          this.visible=false;
          this.name='';
        }

      }
    );

  }

  show() {

    this.visible=true;
  }
   
}
