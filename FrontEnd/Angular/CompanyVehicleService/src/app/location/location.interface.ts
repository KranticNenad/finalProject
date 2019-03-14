import { Country } from '../country/country.interface';

export interface Location{
    locationCode: string;
    name: string;
    dailyPayment: number;
    country: Country;
    
}