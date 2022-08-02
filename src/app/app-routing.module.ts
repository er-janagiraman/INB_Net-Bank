import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAccountComponent } from './component/account/add-account/add-account.component';
import { ChequeDepositComponent } from './component/account/cheque-deposit/cheque-deposit.component';
import { CustomerDetailsComponent } from './component/account/customer-details/customer-details.component';
import { TransactionComponent } from './component/account/transaction/transaction.component';
import { TransferComponent } from './component/account/transfer/transfer.component';
import { AdminComponent } from './component/admin/admin/admin.component';
import { ChequeRequestComponent } from './component/admin/cheque-request/cheque-request.component';
import { CustomerRequestComponent } from './component/admin/customer-request/customer-request.component';
import { CreateAccountComponent } from './component/create-account/create-account.component';
import { LoginComponent } from './component/login/login.component';
import { NewLoginComponent } from './component/new-login/new-login.component';
import { RegisterComponent } from './component/register/register.component';
import { StatusComponent } from './component/status/status.component';
import { ValidateStatusComponent } from './component/validate-status/validate-status.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "newLogin", component: NewLoginComponent },
  { path: "status", component: StatusComponent },
  { path: "validateStatus", component: ValidateStatusComponent },
  { path: "newAcc/:userId", component: CreateAccountComponent },
  { path: "admin", component: AdminComponent },
  { path: "customer/:customerId", component: CustomerDetailsComponent },
  { path: "customerrequest", component: CustomerRequestComponent },
  { path: "addAccount/:customerId", component: AddAccountComponent },
  { path: "transaction/:accountId", component: TransactionComponent },
  { path: "transfer/:accountId", component: TransferComponent },
  { path: "cheque/:accountId", component: ChequeDepositComponent },
  { path: "customerrequest", component: CustomerRequestComponent },
  { path: "chequerequest", component: ChequeRequestComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
