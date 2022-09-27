import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms'
import { Invoice } from 'src/app/model/invoice';
import { InvoiceService } from 'src/app/service/invoice.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  invDetail !: FormGroup;
  invObj : Invoice = new Invoice();
  invList : Invoice[] = [];

  constructor(private formBuilder : FormBuilder, private invService : InvoiceService) { }

  ngOnInit(): void {

    this.getAllInvoice();

    this.invDetail = this.formBuilder.group({
      id : [''],
      name : [''],
      total: [''],
      email: ['']
    });    

  }

  addInvoice() {
    console.log(this.invDetail);
    this.invObj.id = this.invDetail.value.id;
    this.invObj.name = this.invDetail.value.name;
    this.invObj.total = this.invDetail.value.total;
    this.invObj.email = this.invDetail.value.email;

    this.invService.addInvoice(this.invObj).subscribe(res=>{
        console.log(res);
        this.getAllInvoice();
    },err=>{
        console.log(err);
    });

  }

  getAllInvoice() {
    this.invService.getAllInvoice().subscribe(res=>{
        this.invList = res;
    },err=>{
      console.log("unable to find requested data.")
    });
  }

  editInvoice(inv : Invoice) {
    this.invDetail.controls['id'].setValue(inv.id);
    this.invDetail.controls['name'].setValue(inv.name);
    this.invDetail.controls['total'].setValue(inv.total);
    this.invDetail.controls['email'].setValue(inv.email);

  }

  updateInvoice() {

    this.invObj.id = this.invDetail.value.id;
    this.invObj.name = this.invDetail.value.name;
    this.invObj.total = this.invDetail.value.total;
    this.invObj.email = this.invDetail.value.email;

    this.invService.updateInvoice(this.invObj).subscribe(res=>{
      console.log(res);
      this.getAllInvoice();
    },err=>{
      console.log(err);
    })

  }

  deleteInvoice(inv : Invoice) {

    this.invService.deleteInvoice(inv).subscribe(res=>{
      console.log(res);
      alert('Invoice has been removed.');
      this.getAllInvoice();
    },err => {
      console.log(err);
    });

  }

}
