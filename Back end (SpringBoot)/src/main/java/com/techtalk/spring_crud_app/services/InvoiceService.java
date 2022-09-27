package com.techtalk.spring_crud_app.services;

import com.techtalk.spring_crud_app.model.Invoice;
import com.techtalk.spring_crud_app.repository.InvoiceRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> addAllInvoices(List<Invoice> invoices) {
        return  invoiceRepository.saveAll(invoices);
    }

    public Invoice getInvoiceByID(int id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice getInvoiceByName(String name) {
        return  invoiceRepository.findByName(name);
    }

    public Invoice updateInvoice(Invoice invoice) {
        Invoice existingINV = invoiceRepository.findById(invoice.getId()).orElse(null);
        System.out.println(invoice);
        if(existingINV == null) {
            System.out.println("Inv not found");
            return  invoiceRepository.save(invoice);
        }else  {
            existingINV.setName(invoice.getName());
            existingINV.setEmail(invoice.getEmail());
            existingINV.setTotal(invoice.getTotal());
            invoiceRepository.save(existingINV);
        }
        return invoice;
    }

    public boolean deleteInvoiceByID(int id) {
        Invoice existingINV = invoiceRepository.getById(id);
        if(existingINV != null) {
            invoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
