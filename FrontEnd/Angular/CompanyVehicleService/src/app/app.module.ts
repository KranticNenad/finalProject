import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { UserComponent } from './user/user.component';
import { RouterModule } from '@angular/router';
import { GuideComponent } from './guide/guide.component';
import { RegisterComponent } from './register/register.component';
import { EmployeeComponent } from './employee/employee.component';
import { LocationComponent } from './location/location.component';
import { CarComponent } from './car/car.component';
import { WarrantComponent } from './warrant/warrant.component';
import { CountryComponent } from './country/country.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    UserComponent,
    GuideComponent,
    RegisterComponent,
    EmployeeComponent,
    LocationComponent,
    CarComponent,
    WarrantComponent,
    CountryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'home', component: HomepageComponent},
      {path: 'login', component: LoginComponent},
      {path: 'user', component: UserComponent},
      {path: 'guide', component: GuideComponent},
      {path: 'warrant', component: WarrantComponent},
      {path: '', component: LoginComponent},
      {path: 'registration', component: RegisterComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
