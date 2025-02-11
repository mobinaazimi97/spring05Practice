package com.mftplus.spring05practice.invoice;


import java.util.List;


public interface InvoiceService {
    Invoice saveOrder(Invoice invoice);
    Invoice updateOrder(Invoice invoice);
    void deleteOrder(Long id);
    Invoice getOrderById(Long id);
    List<Invoice> findAll();

}
