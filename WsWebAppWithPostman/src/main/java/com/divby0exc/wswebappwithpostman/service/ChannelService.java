package com.divby0exc.wswebappwithpostman.service;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import com.divby0exc.wswebappwithpostman.repository.ChannelRepository;

import java.util.List;


public interface ChannelService {
    public DTOChannel save(DTOChannel s);
    public void deleteDTOChannelById(Long id);
    public List<DTOChannel> getAll();
    public DTOChannel getDTOChannelById(Long id);
}
