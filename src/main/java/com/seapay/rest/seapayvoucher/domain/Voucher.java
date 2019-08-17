package com.seapay.rest.seapayvoucher.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table
@Entity
public class Voucher implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer availableUsage;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailableUsage() {
        return availableUsage;
    }

    public void setAvailableUsage(Integer availableUsage) {
        this.availableUsage = availableUsage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Voucher() {

    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Voucher(String name, Integer availableUsage, BigDecimal amount) {
        this.name = name;
        this.availableUsage = availableUsage;
        this.amount = amount;
    }

    @Column
    private BigDecimal amount;


}
