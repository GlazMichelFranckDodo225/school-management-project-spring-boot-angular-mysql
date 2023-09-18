package com.dgmf.entity;

import com.dgmf.utils.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    // Pay attention to the designation "username" which has a
    // special meaning for the "UserDetails" Interface
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String email;
    private String password;
    private boolean isActive = true;
    @Column(name = "date_created", nullable = false)
    // Hibernate will automatically take the current Timestamp of the JVM
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Column(name = "last_updated")
    // Hibernate will automatically take the current Timestamp of the JVM
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @Enumerated(EnumType.STRING)
    private Role role;
}
