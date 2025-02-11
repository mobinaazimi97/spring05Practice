package com.mftplus.spring05practice.invoice;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    //    @Override
    @Lock(LockModeType.WRITE)
    @Query("select i from invoiceEntity i where i.id = : id and i.deleted=false ")
    Optional<Invoice> findById(@Param("id") Long id);

    // Logical Delete(Not Need to OrphanRemoval In Entity)
    @Query("update invoiceEntity set deleted=true where id = : id")
    void deleteById(Long id);

    @Query("select i from invoiceEntity i where i.deleted=false ")
    List<Invoice> findAll();

    //Join Fetch JPA
    // When we are in @MappedSuperClass/strategy=TABLE_PER_CLASS/Seperated tables :
//@Query("select i from invoiceEntity i join fetch i.cashList")


    //Native SQL Join
    //More Pure And HighPerformance :
    //Query with Parameter
//    @Query(value = "select * from invoiceEntity join cashEntity on invoiceEntity.id = cashEntity.invoice_id where invoiceEntity.id = : id", nativeQuery = true)
//    List<Invoice> findByCashList(@Param("id") Long invoiceId);
}
