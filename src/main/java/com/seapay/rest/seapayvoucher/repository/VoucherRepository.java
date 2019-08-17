package com.seapay.rest.seapayvoucher.repository;

import com.seapay.rest.seapayvoucher.domain.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
}
