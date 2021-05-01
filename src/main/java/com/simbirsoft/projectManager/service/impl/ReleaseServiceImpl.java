package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseAddResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseDeleteResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseUpdateResponse;
import com.simbirsoft.projectManager.entity.Release;
import com.simbirsoft.projectManager.exception.ReleaseNotFoundException;
import com.simbirsoft.projectManager.repository.ReleaseRepository;
import com.simbirsoft.projectManager.service.ReleaseService;
import com.simbirsoft.projectManager.utils.mapper.ReleaseMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    private final ReleaseRepository releaseRepository;

    private final ReleaseMapper releaseMapper;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository,
                              ReleaseMapper releaseMapper) {
        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
    }


    @Override
    public ReleaseResponse getById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Release> releaseOptional = releaseRepository.findById(uuid);
        return releaseOptional.map(releaseMapper::toDto)
                .orElseThrow(() -> new ReleaseNotFoundException("id", id));
    }

    @Override
    public ReleaseAddResponse addRelease(ReleaseRequest request) {
        Release release = releaseMapper.toReleaseEntity(request);
        UUID id = releaseRepository.save(release).getId();
        return new ReleaseAddResponse(id, true);
    }

    @Override
    public ReleaseUpdateResponse updateRelease(String id, ReleaseRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Release> releaseOptional = releaseRepository.findById(uuid);
        if (releaseOptional.isEmpty()) {
            throw new ReleaseNotFoundException("id", id);
        }
        Release newEntity = releaseMapper.toReleaseEntity(request);
        newEntity.setId(uuid);
        releaseRepository.save(newEntity);
        return new ReleaseUpdateResponse(true);
    }

    @Override
    public ReleaseDeleteResponse deleteById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Release> releaseOptional = releaseRepository.findById(uuid);
        if (releaseOptional.isEmpty()) {
            throw new ReleaseNotFoundException("id", id);
        }
        releaseRepository.deleteById(uuid);
        return new ReleaseDeleteResponse(true);
    }
}
