package com.photon.exam.service;

import com.photon.exam.util.Types;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TaxService {

    Double getTaxes(Types type, double price);

    void addTaxes(Types type, double tax);
}
