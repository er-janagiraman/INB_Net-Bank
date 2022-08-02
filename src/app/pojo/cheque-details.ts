import { AccountDetails } from "./account-details";

export class ChequeDetails {

    chequeNo: number = 0;
    accountIdTo: AccountDetails = new AccountDetails();
    accountId: AccountDetails = new AccountDetails();
    depositeAmount: number = 0;
    chequeDate: string = "";
    chequeStatus: string = "";

}