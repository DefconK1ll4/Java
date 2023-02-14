package com.divby0exc.wswebappwithpostman.repository;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<DTOChannel, Long> {
}
