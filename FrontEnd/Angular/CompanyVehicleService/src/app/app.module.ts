
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RouterModule } from '@angular/router';
import { GuideComponent } from './guide/guide.component';
import { RegisterComponent } from './register/register.component';
import { EmployeeComponent } from './employee/employee.component';
import { LocationComponent } from './location/location.component';
import { CarComponent } from './car/car.component';
import { WarrantComponent } from './warrant/warrant.component';
import { CountryComponent } from './country/country.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CheckComponent } from './check/check.component';
import { LogoutComponent } from './logout/logout.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,    
    UserComponent,
    GuideComponent,
    RegisterComponent,
    EmployeeComponent,
    LocationComponent,
    CarComponent,
    WarrantComponent,
    CountryComponent,
    CheckComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    RouterModule.forRoot([      
      {path: 'login', component: LoginComponent},
      {path: 'user', component: UserComponent},
      {path: 'guide', component: GuideComponent},
      {path: 'warrant', component: WarrantComponent},
      {path: 'employee', component: EmployeeComponent},
      {path: 'car', component: CarComponent},
      {path: '', component: LoginComponent},
      {path: 'registration', component: RegisterComponent},
      {path: 'check', component: CheckComponent},
      {path: 'logout', component: LogoutComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
