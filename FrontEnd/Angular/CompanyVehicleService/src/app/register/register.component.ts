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
  password2: string;

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
  public onSubmit():void {

    this.check();
    this.user.username=this.registerForm.get('userName').value;
    this.user.email=this.registerForm.get('email').value;
    this.user.password=this.registerForm.get('password').value;
    this.user.enabled=true;
    this.user.authority='user';
    this.registerService.postUser(this.user).subscribe(user => this.user);
    }

    public check() : boolean {
      console.log("USAO");
      this.user.email=this.registerForm.get('email').value;
      this.user.email=this.registerForm.get('email').value;
      this.user.password=this.registerForm.get('password').value;
      this.password2=this.registerForm.get('confirmPassword').value;
      if(this.user.password != this.password2) {
        console.log("PASSWORDS ARE NOT EQUAL");
        return false;
      }
      else {
        console.log("true");
        console.log(this.user.email + "regex email");
        let username= /^[A-Z][a-z]{7,15}$"/.test(this.user.username);
        console.log(username + "regex Username");       
        let pass=/^(?=.*[\d])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*])[\w!@#$%^&*]{8,}$/.test(this.user.password);
        console.log(pass);
        let re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        console.log(re.test(String(this.user.email).toLowerCase()));
        return re.test(String(this.user.email).toLowerCase());
      }
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