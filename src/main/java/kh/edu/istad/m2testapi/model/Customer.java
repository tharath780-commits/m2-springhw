package kh.edu.istad.m2testapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="customers")

public class Customer {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true, length = 12)
    private String phoneNumber;
    @Column(nullable = false,unique = true, length = 82)
    private String email;
    private String address;

}
