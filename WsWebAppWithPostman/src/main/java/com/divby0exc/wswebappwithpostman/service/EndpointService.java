package com.divby0exc.wswebappwithpostman.service;

import com.divby0exc.wswebappwithpostman.model.UserDefinedEndpoint;

import java.util.List;

public interface EndpointService {

    List<UserDefinedEndpoint> getAllEndpoints();
    UserDefinedEndpoint save(UserDefinedEndpoint ue);
}
