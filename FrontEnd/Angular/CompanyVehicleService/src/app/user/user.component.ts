import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  private username: string;  
  private password: string; 
  private enabled: boolean;  
  private authority: string;  
  private email: string;
  

  constructor(username: string, password: string, enabled: boolean, authority: string, email: string) { 
    this.username=username;
    this.password=password;
    this.enabled=enabled;
    this.authority=authority;
    this.email=email;
  }

  public getUsername(): string {
    return this.username;
  }
  public setUsername(value: string) {
    this.username = value;
  }

  public getPassword(): string {
    return this.password;
  }
  public setPassword(value: string) {
    this.password = value;
  }

  public getEnabled(): boolean {
    return this.enabled;
  }
  public setEnabled(value: boolean) {
    this.enabled = value;
  }

  public getAuthority(): string {
    return this.authority;
  }
  public setAuthority(value: string) {
    this.authority = value;
  }

  public getEmail(): string {
    return this.email;
  }
  public setEmail(value: string) {
    this.email = value;
  }

  ngOnInit() {
  }

}
