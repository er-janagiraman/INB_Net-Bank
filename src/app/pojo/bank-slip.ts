import { AccountDetails } from "./account-details";
import { ChequeDetails } from "./cheque-details";

export class BankSlipDetails {

    bankSlipId: number = 0;
    accountId: AccountDetails = new AccountDetails();
    accountIdTo: AccountDetails = new AccountDetails();
    chequeNo: number = 0;
    chequeDetails: ChequeDetails = new ChequeDetails();
}