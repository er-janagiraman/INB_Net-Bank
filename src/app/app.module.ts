import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NewLoginComponent } from './component/new-login/new-login.component';
import { StatusComponent } from './component/status/status.component';
import { ValidateStatusComponent } from './component/validate-status/validate-status.component';
import { CreateAccountComponent } from './component/create-account/create-account.component';
import { CustomerRequestComponent } from './component/admin/customer-request/customer-request.component';
import { AdminComponent } from './component/admin/admin/admin.component';
import { CustomerDetailsComponent } from './component/account/customer-details/customer-details.component';
import { AddAccountComponent } from './component/account/add-account/add-account.component';
import { TransactionComponent } from './component/account/transaction/transaction.component';
import { TransferComponent } from './component/account/transfer/transfer.component';
import { ChequeDepositComponent } from './component/account/cheque-deposit/cheque-deposit.component';
import { ChequeRequestComponent } from './component/admin/cheque-request/cheque-request.component';
import { DataTablesModule } from 'angular-datatables';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NewLoginComponent,
    StatusComponent,
    ValidateStatusComponent,
    CreateAccountComponent,
    RegisterComponent,
    CustomerRequestComponent,
    AdminComponent,
    CustomerDetailsComponent,
    AddAccountComponent,
    TransactionComponent,
    TransferComponent,
    ChequeDepositComponent,
    ChequeRequestComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
