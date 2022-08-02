import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountDetails } from '../pojo/account-details';
import { BankSlipDetails } from '../pojo/bank-slip';
import { ChequeDetails } from '../pojo/cheque-details';
import { CustomerDetails } from '../pojo/customer-details';
import { TransactionDetails } from '../pojo/transaction-details';

@Injectable({
  providedIn: 'root'
})

export class CustomerService {

  private baseURL: string = "http://192.168.1.63:8080/netbankingapi/";

  constructor(private http: HttpClient) { }

  newCustomerDetails(newCustomerDetails: CustomerDetails): Observable<boolean> {
    return this.http.post<boolean>(this.baseURL + "login", newCustomerDetails);
  }

  checkStatus(userId: string): Observable<CustomerDetails> {
    return this.http.get<CustomerDetails>(this.baseURL + "customerdetailsbyuserid/" + userId);
  }

  addAccount(accountDetails: AccountDetails): Observable<boolean> {
    return this.http.post<boolean>(this.baseURL + "accountdetails/addnew", accountDetails);
  }

  getallcustomer(): Observable<AccountDetails[]> {
    return this.http.get<AccountDetails[]>(this.baseURL + "accountdetails/pendingaccounts");
  }

  getcustomerdetails(): Observable<AccountDetails[]> {
    return this.http.get<AccountDetails[]>(this.baseURL + "accountdetails/pendingaccounts");
  }

  getcustomerdetailsbyuserid(userId: string): Observable<CustomerDetails> {
    return this.http.get<CustomerDetails>(this.baseURL + "customerdetailsbyuserid/" + userId);
  }

  getcustomerdetailsbycustomerid(customerId: string): Observable<AccountDetails[]> {
    return this.http.get<AccountDetails[]>(this.baseURL + "accountdetails/" + customerId);
  }

  createAccount(accountDetails: AccountDetails): Observable<boolean> {
    return this.http.post<boolean>(this.baseURL + "accountdetails/addnew", accountDetails);
  }

  customerIdDetails(customerId: string): Observable<CustomerDetails> {
    return this.http.get<CustomerDetails>(this.baseURL + "customerdetails/" + customerId);
  }

  transactionHistory(accountId: number): Observable<TransactionDetails[]> {
    return this.http.get<TransactionDetails[]>(this.baseURL + "transactiondetails/" + accountId);
  }

  dataAcountId(transactionDetails: TransactionDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "transactiondetail/transfer", transactionDetails);
  }

  getCheque(accountId: number): Observable<ChequeDetails[]> {
    return this.http.get<ChequeDetails[]>(this.baseURL + "cheque/" + accountId);
  }

  chequeDeposit(chequeDetail: ChequeDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "chequedetails/chequedeposite", chequeDetail);
  }

  accDetailByAcc(accountId: number): Observable<AccountDetails> {
    return this.http.get<AccountDetails>(this.baseURL + "accountdetail/" + accountId);
  }

  chequeStatus(): Observable<ChequeDetails[]> {
    return this.http.get<ChequeDetails[]>(this.baseURL + "chequedetails/chequestatus")
  }

  approve(bankSlip: BankSlipDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "bankslip/chequedeposit", bankSlip);
  }

  chequeDetails(chequeNo: number): Observable<ChequeDetails> {
    return this.http.get<ChequeDetails>(this.baseURL + "chequedetails/" + chequeNo);
  }

  getbank(accountId: number): Observable<BankSlipDetails> {
    return this.http.get<BankSlipDetails>(this.baseURL + "bankslip/" + accountId);
  }

  getDataAcountId(accountId: number): Observable<AccountDetails> {
    return this.http.get<AccountDetails>(this.baseURL + "accountdetail/" + accountId);
  }

  fdaccount(accountDetails: AccountDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "transactiondetail/fixeddeposite", accountDetails);
  }

  mailVerification(customerDetails: CustomerDetails): Observable<boolean> {
    return this.http.post<boolean>(this.baseURL + "sendmail", customerDetails);
  }

}
