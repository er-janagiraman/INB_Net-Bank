import { LoginDetails } from "./login-details";

export class CustomerDetails {

    customerId: string = '';
    firstName: string = '';
    lastName: string = '';
    addressLine1: string = '';
    addressLine2: string = '';
    addressLine3: string = '';
    city: string = '';
    state: string = '';
    zipcode: number = 0;
    landLine: number = 0;
    mobileNumber: number = 0;
    emailId: string = '';
    typeOfAccount: string = '';
    customerStatus: string = '';

    loginDetails: LoginDetails = new LoginDetails();

}