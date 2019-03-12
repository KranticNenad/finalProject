import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ngOnInit(){
    
  }


  // registerForm: FormGroup;
  // submitted = false;

  // constructor(private formBuilder: FormBuilder) { }

  // ngOnInit() {
  //     this.registerForm = this.formBuilder.group({
  //         userName: ['', Validators.required],
  //         email: ['', [Validators.required, Validators.email]],
  //         password: ['', [Validators.required, Validators.minLength(6)]],
  //         confirmPassword: ['', Validators.required]
  //     }, {
  //     });
  // }

  // // convenience getter for easy access to form fields
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
