package com.photon.exam.service;

import com.photon.exam.util.Types;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static com.photon.exam.util.Constants.TIERED_BASE_PRICE;

@Service
@Transactional
public class TaxServiceImp implements TaxService {

    private Map<Types, Double> data = new HashMap<>();

    public Double getTaxes(Types type, double price) {
        if (type == null)
            return null;
        if (Types.TIERED == type && price > TIERED_BASE_PRICE) {
            return 15.0;
        }
        return data.get(type);
    }

    public void addTaxes(Types type, double tax) {
        data.put(type, tax);
    }
}
