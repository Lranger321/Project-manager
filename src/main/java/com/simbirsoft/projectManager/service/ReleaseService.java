package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.dto.response.ReleaseResponse;

import java.util.UUID;

public interface ReleaseService {

    ReleaseResponse getById (String id);

    UUID addRelease (ReleaseRequest request);

    boolean updateRelease (String id, ReleaseRequest request);

    boolean deleteById (String id);
}
