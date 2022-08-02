import { AccountDetails } from "./account-details";

export class TransactionDetails {

    transactionId: number = 0;
    accountIdTo: AccountDetails = new AccountDetails();
    accountId: AccountDetails = new AccountDetails();
    transactionAmount: number = 0;
    transactionDate: string = "";
    transactionTime: string = "";
    transactionType: string = '';

}