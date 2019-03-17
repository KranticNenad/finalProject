export interface WarrantDto {
    warrantId: number;
    issuedAt: Date;
    distance: number;
    returnedAt: Date;
    fuelUsed: number;
    regNo: string;
    employeeId: number;
    username: string;
    locationCodes: string[];
}