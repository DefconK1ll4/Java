package com.divby0exc.wswebappwithpostman.repository;

import com.divby0exc.wswebappwithpostman.model.UserDefinedEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointRepository extends JpaRepository<UserDefinedEndpoint, Long> {
}
