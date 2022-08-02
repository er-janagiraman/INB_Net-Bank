import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionDetails } from 'src/app/pojo/transaction-details';
import { CustomerService } from 'src/app/service/customer.service';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})

export class TransactionComponent implements OnInit {

  customerId: string | null = "";
  accountId: number = 0;
  transactionHistory: TransactionDetails[] = [];

  constructor(private route: ActivatedRoute, private customerService: CustomerService, private router: Router) { }
  @ViewChild('htmlData') htmlData!: ElementRef;

  ngOnInit(): void {
    this.accountId = this.route.snapshot.params['accountId'];
    this.customerService.transactionHistory(this.accountId).subscribe(data => {
      this.transactionHistory = data;
    });
    this.customerId = localStorage.getItem('key');
  }

  home() {
    this.router.navigate(['customer', this.customerId]);
  }

  download() {
    let DATA: any = document.getElementById('target');
    html2canvas(DATA).then((canvas) => {
      let fileWidth = 208;
      let fileHeight = (canvas.height * fileWidth) / canvas.width;
      const FILEURI = canvas.toDataURL('image/png');
      let PDF = new jsPDF('p', 'mm', 'a4');
      let position = 0;
      PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight);
      PDF.save('Transaction_File.pdf');
    });
  }
}

