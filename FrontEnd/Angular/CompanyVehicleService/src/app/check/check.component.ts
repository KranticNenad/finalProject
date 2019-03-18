import { Component, OnInit } from '@angular/core';
import { CheckService } from '../check.service';
import { Login } from '../login/login.interface';

@Component({
  selector: 'app-check',
  templateUrl: './check.component.html',
  styleUrls: ['./check.component.css']
})
export class CheckComponent implements OnInit {

  login: Login;
  status: string='';

  constructor(private checkService: CheckService ) { }

  ngOnInit() {
    this.checkService.getStatus().subscribe(data => { 
      console.log(data);
      this.login = data;
      this.status='uspesno';
      console.log(data);
      console.log(this.login);
    }
      );
  }

}
