import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { WarrantsComponent } from './warrants/warrants.component';
import { CarsComponent } from './cars/cars.component';
import { EmployeesComponent } from './employees/employees.component';
import { UserComponent } from './user/user.component';
import { RouterModule } from '@angular/router';
import { GuideComponent } from './guide/guide.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    WarrantsComponent,
    CarsComponent,
    EmployeesComponent,
    UserComponent,
    GuideComponent,
    RegisterComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'home', component: HomepageComponent},
      {path: 'login', component: LoginComponent},
      {path: 'employees', component: EmployeesComponent},
      {path: 'cars', component: CarsComponent},
      {path: 'user', component: UserComponent},
      {path: 'warrants', component: WarrantsComponent},
      {path: 'guide', component: GuideComponent},
      {path: 'user/login', component: LoginComponent},
      {path: 'user/registration', component: RegisterComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
