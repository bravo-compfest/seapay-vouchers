package com.seapay.rest.seapayvoucher;

import com.seapay.rest.seapayvoucher.domain.Voucher;
import com.seapay.rest.seapayvoucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

public class DBInit implements CommandLineRunner {
    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public void run(String... args) throws Exception {
        Voucher diskon_banyak = new Voucher("diskon banyak", 10, new BigDecimal("50000.0"));
        voucherRepository.save(diskon_banyak);
    }
}

