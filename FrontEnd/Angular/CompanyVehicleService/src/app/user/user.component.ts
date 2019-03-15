import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  visible: boolean = false;
  visible2: boolean = false;
  visible3: boolean = false;

  ngOnInit() {
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
