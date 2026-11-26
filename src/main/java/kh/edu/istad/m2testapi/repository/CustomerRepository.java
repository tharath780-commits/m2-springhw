package kh.edu.istad.m2testapi.repository;

import kh.edu.istad.m2testapi.model.Customer;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {



}
