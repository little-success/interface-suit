package com.suit.interfaces.dao;

import com.suit.interfaces.entity.Hosts;
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
 * @date 2020/7/7
 */
@Repository
public interface HostRepository extends JpaRepository<Hosts,Long> {
    @Modifying
    @Transactional
    @Query("update hosts set hosts=?2 where id=?1")
    void change(Long id, String hosts);

}
