import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { UserComponent } from '../user/user.component';
import { User } from '../user/user.interface';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User= {
    username: '',  
    password: '', 
    enabled: false,  
    authority: '',  
    email: ''
  }
  ngOnInit() {
  }
  

  constructor(private formBuilder: FormBuilder,private registerService: RegisterService) { 
  }

  registerForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl(''),
    email: new FormControl('')
  });
  onSubmit() {
    
    this.user.username=this.registerForm.get('userName').value;
    this.user.email=this.registerForm.get('email').value;
    this.user.password=this.registerForm.get('password').value;
    this.user.enabled=true;
    this.user.authority='user';
    this.registerService.postUser(this.user).subscribe(user => this.user);
    }
  // registerForm: FormGroup;
  // submitted = false;


  // ngOnInit() {
  //     this.registerForm = this.formBuilder.group({
  //         userName: ['', Validators.required],
  //         email: ['', [Validators.required, Validators.email]],
  //         password: ['', [Validators.required, Validators.minLength(6)]],
  //         confirmPassword: ['', Validators.required]
  //     }, {
  //     });
  // }

  // convenience getter for easy access to form fields
  // get f() { return this.registerForm.controls; }

  // onSubmit() {
  //     this.submitted = true;

  //     // stop here if form is invalid
  //     if (this.registerForm.invalid) {
  //         return;
  //     }

  //     console.log('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value))
  // }
}