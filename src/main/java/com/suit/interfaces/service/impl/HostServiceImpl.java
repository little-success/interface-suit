package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.HostRepository;
import com.suit.interfaces.entity.Hosts;
import com.suit.interfaces.service.HostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
public class HostServiceImpl implements HostsService {

    @Autowired
    private HostRepository hostRepository;
    @Override
    public boolean saveHost(Hosts hosts) {
        try {
            hostRepository.save(hosts);
            return true;
        }catch (Exception e){
            return false;
        }




    }

    @Override
    public boolean changeHost(Long id, String host) {
        if(hostRepository.existsById(id)){
            hostRepository.change(id,host);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<Hosts> findAll() {
        List<Hosts> hosts = hostRepository.findAll();
        return hosts;
    }

    @Override
    public Optional<Hosts> findById(Long id) {
        Optional<Hosts> host = hostRepository.findById(id);
        return host;
    }

    @Override
    public boolean deleteById(Long id) {
        if (hostRepository.existsById(id)) {
            hostRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
