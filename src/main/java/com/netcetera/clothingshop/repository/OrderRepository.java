package com.netcetera.clothingshop.repository;

import com.netcetera.clothingshop.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long> {
}
