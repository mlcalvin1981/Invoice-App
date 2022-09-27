package com.techtalk.spring_crud_app.controller;

import com.techtalk.spring_crud_app.model.Invoice;
import com.techtalk.spring_crud_app.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/inv")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Add new Invoice
    @PostMapping("/addInvoice")
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }

    // Add more than 1 Invoice
    @PostMapping("/addInvoices")
    public List<Invoice> addAllInvoices(@RequestBody List<Invoice> invoices) {
        return invoiceService.addAllInvoices(invoices);
    }

    // Get Invoice by Id
    @GetMapping("/getInvoiceByID/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        return invoiceService.getInvoiceByID(id);
    }

    // Get Invoice by name
    @GetMapping("/getInvoiceByName/{name}")
    public Invoice getInvoiceByName(@PathVariable String name) {
        return  invoiceService.getInvoiceByName(name);
    }

    // Update Invoice
    @PutMapping("/updateInvoice")
    public Invoice updateInvoice(@RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(invoice);
    }

    // Delete Invoice
    @DeleteMapping("/deleteInvoiceById/{id}")
    public boolean deleteInvoiceByID(@PathVariable int id) {
        return invoiceService.deleteInvoiceByID(id);
    }

    // Get all Invoice
    @GetMapping("/getAll")
    public List<Invoice> getAllInvoice() {
        return invoiceService.getAllInvoices();
    }
}
