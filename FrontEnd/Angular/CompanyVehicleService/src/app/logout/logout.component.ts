import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../logout.service';
import { Router } from '@angular/router';
import { CheckService } from '../check.service';
import { Login } from '../login/login.interface';



@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  private status: string= '';
  login:Login;

  constructor(private logService: LogoutService,private router: Router,private checkService: CheckService) { }

  ngOnInit() {
    this.status='YOU HAVE LOGGED OUT';
    this.login = {
      status: 'false',
      auth: 'false',
      userName: ''
      
    }
    this.logService.Logout().subscribe(() => {
      this.checkService.getArgument(this.login);
      this.router.navigate(['/']);
      console.log("YOU HAVE LOGGED OUT" + this.status);
    });
  }

}
