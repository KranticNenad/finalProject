import { UserService } from './user.service';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { User } from './user.interface';
import * as jsPDF from 'jspdf';
import 'jspdf-autotable';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  visible: boolean = false;
  visible2: boolean = false;
  visible3: boolean = false;
  searchVar: string='';

  public search(arg): void {
    this.searchVar=arg.target.value;
}

public show(arg:any): boolean {
 
  if(this.searchVar =='' || arg.username.startsWith(this.searchVar) ) {
    return true;
  }
  else {
  return false;     
}
}

  users:User[];
  userToDelete: string;

  public constructor(private userService: UserService) {
  }

  addForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    enabled: new FormControl(),
    authority: new FormControl(''),
    email: new FormControl('')
  });
  editForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    enabled: new FormControl(),
    authority: new FormControl(''),
    email: new FormControl('')
  });

  saveAsPdf() {

    var doc = new jsPDF('l', 'mm', 'a4');
    let rows = [];

    this.users.forEach(user => {
      rows.push([user.username, user.password, user.enabled, user.authority, user.email]);
    });

    doc.autoTable({
      head:[["Username","Password","Enabled","Authority","Email"]],
      body:rows
    });
    doc.save("Users.pdf");
  }

  addUser() {
    let username : string = this.addForm.get('username').value;
    let password  : string = this.addForm.get('password').value;
    let enabled : boolean = this.addForm.get('enabled').value;
    let authority: string = this.addForm.get('authority').value;
    let email : string = this.addForm.get('email').value;

    let userToAdd : User = {username:username, password: password, enabled: enabled, authority: authority, email:email};

    this.userService.postUser(userToAdd).subscribe(user => userToAdd);
    this.users.push(userToAdd);
    this.visible = false;
  }

  clickedOnUser(user:User){
    this.editForm.setValue({username: user.username, password: user.password, enabled: user.enabled.toString(), authority: user.authority, email: user.email});
  }

  editUser(){
    let username : string = this.editForm.get('username').value;
    let password  : string = this.editForm.get('password').value;
    let enabled : boolean = this.editForm.get('enabled').value;
    let authority: string = this.editForm.get('authority').value;
    let email : string = this.editForm.get('email').value;

    let userToEdit : User = {username:username, password: password, enabled: enabled, authority: authority, email:email};

    this.userService.putUser(userToEdit).subscribe(user => userToEdit);
    this.users[this.users.findIndex(User => User.username == userToEdit.username)] = userToEdit;
    this.visible2 = false;
  }

  setUserDelete(username : string){
    this.userToDelete = username;
  }

  deleteUser(){
    this.userService.deleteUser(this.userToDelete).subscribe();
    this.users = this.users.filter(User => User.username != this.userToDelete);
    this.visible3 = false;
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(data => this.users = data);
  }

  makeVisible(){
    this.visible=true;
  }

  closeVisible(){
    this.visible=false;
  }

  makeVisible2(){
    this.visible2=true;
  }

  closeVisible2(){
    this.visible2=false;
  }

  makeVisible3(){
    this.visible3=true;
  }

  closeVisible3(){
    this.visible3=false;
  }

}
