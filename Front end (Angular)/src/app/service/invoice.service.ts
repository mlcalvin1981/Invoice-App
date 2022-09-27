import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Invoice } from '../model/invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  addInvURL : string;
  getInvURL : string;
  updateInvUrl : string;
  deleteInvUrl : string;

  constructor(private http : HttpClient) {

    this.addInvURL = 'http://localhost:9091/inv/addInvoice';
    this.getInvURL = 'http://localhost:9091/inv/getAll';
    this.updateInvUrl = 'http://localhost:9091/inv/updateInvoice';
    this.deleteInvUrl = 'http://localhost:9091/inv/deleteInvoiceById';

   }

   addInvoice(inv : Invoice): Observable<Invoice> {
     return this.http.post<Invoice>(this.addInvURL,inv);
   }

   getAllInvoice(): Observable<Invoice[]>{
     return this.http.get<Invoice[]>(this.getInvURL);
   }

   updateInvoice(inv :Invoice) : Observable<Invoice>{
     return this.http.put<Invoice>(this.updateInvUrl, inv);
   }

   deleteInvoice(inv : Invoice) : Observable<Invoice> {
     return this.http.delete<Invoice>(this.deleteInvUrl+'/'+inv.id);
   }
  

}
