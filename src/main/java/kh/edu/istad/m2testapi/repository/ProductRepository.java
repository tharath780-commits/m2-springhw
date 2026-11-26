package kh.edu.istad.m2testapi.repository;

import kh.edu.istad.m2testapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {



}
