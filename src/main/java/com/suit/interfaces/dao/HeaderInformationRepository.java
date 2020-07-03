package com.suit.interfaces.dao;

import com.suit.interfaces.entity.HeaderInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Query("update header_information set header_name=?2,header_info=?3 where id=?1")
    void change(Long id,String headerName,String headerInfo);

}
