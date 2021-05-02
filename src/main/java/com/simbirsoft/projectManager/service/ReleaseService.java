package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseAddResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseDeleteResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseUpdateResponse;

public interface ReleaseService {

    ReleaseResponse getById (String id);

    ReleaseAddResponse addRelease (ReleaseRequest request);

    ReleaseUpdateResponse updateRelease (String id, ReleaseRequest request);

    ReleaseDeleteResponse deleteById (String id);
}
