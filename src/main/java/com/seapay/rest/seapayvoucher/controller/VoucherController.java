package com.seapay.rest.seapayvoucher.controller;

import com.seapay.rest.seapayvoucher.domain.Voucher;
import com.seapay.rest.seapayvoucher.exception.EmptyVoucherAvailable;
import com.seapay.rest.seapayvoucher.exception.ResourceNotFoundException;
import com.seapay.rest.seapayvoucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoucherController {
    @Autowired
    private VoucherRepository voucherRepository;

    @PostMapping(value = "/vouchers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Voucher save(@RequestBody Voucher voucher){
        return voucherRepository.save(voucher);
    }

    @GetMapping(value = "/vouchers")
    public Page<Voucher> all(Pageable pageable){
        return voucherRepository.findAll(pageable);
    }

    @GetMapping(value = "/vouchers/{voucherId}")
    public Voucher findByCustomerId (@PathVariable Integer voucherId) {
        return voucherRepository.findById(voucherId).orElseThrow(() -> new ResourceNotFoundException("Voucher [voucherId="+voucherId+"] can't be found"));
    }

    @GetMapping(value = "/vouchers/{voucherId}/useVoucher")
    public ResponseEntity<Voucher> reduceVoucherUsage (@PathVariable Integer voucherId) {
        return voucherRepository.findById((voucherId)).map(voucher -> {
            if(voucher.getAvailableUsage()<=0) {
                throw new EmptyVoucherAvailable("Voucher [voucherId="+voucherId+"] available usage is <=0");
            }
            voucher.setAvailableUsage(voucher.getAvailableUsage()-1);
            voucherRepository.save(voucher);
            return ResponseEntity.ok(voucher);
        }).orElseThrow(() -> new ResourceNotFoundException("Voucher [voucherId="+voucherId+"] can't be found"));

    }

    @PutMapping(value = "/vouchers/{voucherId}")
    public ResponseEntity<Voucher> updateCustomer(@PathVariable Integer voucherId, @RequestBody Voucher newVoucher) {
        return voucherRepository.findById(voucherId).map(voucher -> {
            voucher.setName(newVoucher.getName());
            voucher.setAmount(newVoucher.getAmount());
            voucher.setAvailableUsage(newVoucher.getAvailableUsage());
            voucherRepository.save(voucher);
            return ResponseEntity.ok(voucher);
        }).orElseThrow(() -> new ResourceNotFoundException("Voucher [voucherId="+voucherId+"] can't be found"));
    }
}
