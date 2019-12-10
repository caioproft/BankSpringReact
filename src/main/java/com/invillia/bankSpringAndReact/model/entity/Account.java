package com.invillia.bankSpringAndReact.model.entity;

import com.invillia.bankSpringAndReact.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Double balance;

    @Column
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn
    private User user;
}
