import { Car } from '../car/car.interface';
import { Employee } from '../employee/employee.interface';
import { User } from '../user/user.interface';
import { Location } from '../location/location.interface';

export interface Warrant{
    warrantId: number;
    issuedAt: Date;
    distance: number;
    returnedAt: Date;
    fuelUsed: number;
    car: Car;
    employee: Employee;
    user: User;
    locations: Location[];

}