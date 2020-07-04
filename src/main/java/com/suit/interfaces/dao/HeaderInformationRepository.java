package com.suit.interfaces.dao;

import com.suit.interfaces.entity.HeaderInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * dao层
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */
@Repository
public interface HeaderInformationRepository extends JpaRepository<HeaderInformation,Long> {

    @Modifying
    @Transactional
    @Query("update header_information set header_name=?2,header_info=?3,business_type=?4,update_time=?5 where id=?1")
    void change(Long id, String headerName, String headerInfo, String businessType, Date updateTime);


    @Query(value="select * from header_information where business_type=?1" ,nativeQuery=true)
    public List<HeaderInformation> findByType(String businessType);


    @Query(value="select * from header_information where header_name=?1" ,nativeQuery=true)
    public HeaderInformation findByName(String headerName);
}
