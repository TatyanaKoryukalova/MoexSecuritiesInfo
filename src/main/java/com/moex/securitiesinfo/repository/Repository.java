package com.moex.securitiesinfo.repository;

import com.moex.securitiesinfo.model.DataSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface Repository<T extends DataSet> extends JpaRepository<T,Long> {
    Optional<T> readBySecurityId(String securityId);
}
