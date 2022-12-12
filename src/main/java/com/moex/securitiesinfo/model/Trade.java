package com.moex.securitiesinfo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "trades")
public class Trade implements DataSet{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String securityId;
    private LocalDate tradeDate;
    //numtrades найдено не было, предположила, что это то, что нужно
    private String tradingSessions;
    private Double open;
    private Double close;

}
