package com.techtalk.spring_crud_app.repository;


import com.techtalk.spring_crud_app.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    Invoice getByName(String name);

    Invoice findByName(String name);
}
