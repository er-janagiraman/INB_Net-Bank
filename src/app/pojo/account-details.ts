import { CustomerDetails } from "./customer-details";

export class AccountDetails {

    accountId: number = 0;
    accountStatus: string = "";
    currentBalance: number = 0;
    minimumBalance: number = 0;
    rateOfInterest: number = 0;
    overdraft: number = 0;
    openingDate: Date = new Date();
    typeOfAccount: string = "";

    customerDetails: CustomerDetails = new CustomerDetails();

}