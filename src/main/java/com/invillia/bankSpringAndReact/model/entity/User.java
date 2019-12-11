package com.invillia.bankSpringAndReact.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false)
    private double balance;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;
}
