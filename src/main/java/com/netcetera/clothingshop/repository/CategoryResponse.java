package com.netcetera.clothingshop.repository;

import com.netcetera.clothingshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryResponse extends JpaRepository<Category, Long> {
}
