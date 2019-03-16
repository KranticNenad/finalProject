import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-warrant',
  templateUrl: './warrant.component.html',
  styleUrls: ['./warrant.component.css']
})
export class WarrantComponent implements OnInit {

  visible: boolean = false;
  visible2: boolean = false;
  visible3: boolean = false;
  visible4: boolean = false;
  searchVar: string='';

  public search(arg): void {
    this.searchVar=arg.target.value;
}

public show(arg:any): boolean {
 
  if(this.searchVar =='' || arg.warrantId.startsWith(this.searchVar) ) {
    return true;
  }
  else {
  return false;     
}
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

  makeVisible4(){
    this.visible4=true;
  }

  closeVisible4(){
    this.visible4=false;
  }
  

  ngOnInit() {
}
}


