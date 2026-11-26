package kh.edu.istad.m2testapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 50 , nullable = false, unique = true)
    private String name;
    @Column(length = 32)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Product> products;
}
