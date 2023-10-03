package com.ssafy.mini.domain.shop.repository;

import com.ssafy.mini.domain.nation.entity.Nation;
import com.ssafy.mini.domain.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByProdName(String prodName);

    List<Product> findAllByIsoSeq(Nation nation);

}
