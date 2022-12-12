package com.moex.securitiesinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "securities")
public class Security implements DataSet {
    @Id
    private Long id;
    private String securityId;
    private String registrationNumber;
    private String name;
    private String emitentTitle;
}
