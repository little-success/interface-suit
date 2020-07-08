package com.suit.interfaces.dao;

import com.suit.interfaces.entity.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@Repository
public interface BusinessTypeRepository extends JpaRepository<BusinessType,Long> {

    @Modifying
    @Transactional
    @Query(value = "update business_type set type_name=?2,update_time=?3 where id=?1", nativeQuery=true)
    void change(Long id, String typeName, Date updateTime);
}
