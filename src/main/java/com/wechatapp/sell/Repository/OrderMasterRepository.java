package com.wechatapp.sell.Repository;

import com.wechatapp.sell.DataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    // if not use Pageable, the result would be all orders of a buyer which could be
    // a huge many.
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
