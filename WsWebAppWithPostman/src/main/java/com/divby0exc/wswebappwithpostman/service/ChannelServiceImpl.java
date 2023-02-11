package com.divby0exc.wswebappwithpostman.service;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import com.divby0exc.wswebappwithpostman.repository.ChannelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.Channel;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    ChannelRepository repo;

    @Override
    public DTOChannel save(DTOChannel s) {
        return repo.save(s);
    }

    @Override
    public void deleteDTOChannelById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<DTOChannel> getAll() {
        return repo.findAll();
    }

    @Override
    public DTOChannel getDTOChannelById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }
}
