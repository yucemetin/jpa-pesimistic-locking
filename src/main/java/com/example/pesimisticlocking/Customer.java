package com.example.pesimisticlocking;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Formula("first_name.concat(last_name)")
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "test")
    @Formula("balance. * 10")
    private BigDecimal test;

    @Version
    private Integer version;
}
