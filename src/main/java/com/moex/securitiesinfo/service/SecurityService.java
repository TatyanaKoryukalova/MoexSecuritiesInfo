package com.moex.securitiesinfo.service;

import com.moex.securitiesinfo.model.Security;

public class SecurityService extends AbstractMoexService<Security>{

    @Override
    public Security create(Security entity) {
        return repository.save(entity);
    }
}
