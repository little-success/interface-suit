package com.suit.interfaces.service;
import com.suit.interfaces.entity.Hosts;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/7
 */
@Service
public interface HostsService {
    boolean saveHost(Hosts hosts);
    boolean changeHost(Long id, String host);
    List<Hosts> findAll();
    Optional<Hosts> findById(Long id);
    boolean deleteById(Long id);
}
