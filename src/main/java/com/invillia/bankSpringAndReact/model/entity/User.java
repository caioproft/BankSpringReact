package com.invillia.bankSpringAndReact.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column (nullable = false)
    @NonNull
    private String name;

    @Column (nullable = false)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Account account;

    @CreationTimestamp
    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
