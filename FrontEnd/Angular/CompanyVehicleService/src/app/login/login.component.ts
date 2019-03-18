import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { LoginService } from '../login.service';
import { Login } from './login.interface';
import { Router } from '@angular/router';
import { CheckService } from '../check.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title: string = 'ime';
  username: string = '';
  password: string = '';
  login: Login;

  constructor(private loginService: LoginService, private router: Router,private checkService: CheckService) {
  }

  registerForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl('')
  });
  submitted = false;


  ngOnInit() {
  }


  onSubmit() {
    this.username = this.registerForm.get('userName').value;
    this.password = this.registerForm.get('password').value;
    console.log(this.username);
    console.log(this.password);
    console.log('http://localhost:8080/finalProject/login?username=' + this.username + '&' + 'password=' + this.password);
    this.loginService.getStatus(this.username, this.password).subscribe(data => this.login = data);
    setTimeout(() => {
      if (this.login.status == 'true') {
          this.router.navigate(['/car']);
          this.checkService.getArgument(this.login);
      }
    },5000);
    
  }
}
