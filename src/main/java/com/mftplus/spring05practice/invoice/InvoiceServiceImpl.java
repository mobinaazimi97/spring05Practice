package com.mftplus.spring05practice.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override
    public Invoice saveOrder(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateOrder(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteOrder(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Invoice getOrderById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

}
