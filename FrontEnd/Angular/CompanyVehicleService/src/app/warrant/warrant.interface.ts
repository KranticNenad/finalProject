import { NumberValueAccessor } from '@angular/forms/src/directives';
import { Car } from '../car/car.interface';
import { Employee } from '../employee/employee.interface';
import { UserComponent } from '../user/user.component';
import { User } from '../user/user.interface';

export interface Warrant{
    warrantId: number;
    issuedAt: Date;
    distance: number;
    returnedAt: Date;
    fuelUsed: number;
    car: Car;
    emoployee: Employee;
    user: User;
    location: Location[];

}