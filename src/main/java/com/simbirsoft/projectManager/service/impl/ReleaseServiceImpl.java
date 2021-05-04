package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.dto.response.ReleaseResponse;
import com.simbirsoft.projectManager.entity.Release;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.ReleaseRepository;
import com.simbirsoft.projectManager.service.ReleaseService;
import com.simbirsoft.projectManager.utils.mapper.ReleaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public ReleaseResponse getById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Release> releaseOptional = releaseRepository.findById(uuid);
        return releaseOptional.map(releaseMapper::toDto)
                .orElseThrow(() -> new NotFoundException(Release.class, "id", id));
    }

    @Transactional
    @Override
    public UUID addRelease(ReleaseRequest request) {
        Release release = releaseMapper.toReleaseEntity(request);
        return releaseRepository.save(release).getId();
    }

    @Transactional
    @Override
    public boolean updateRelease(String id, ReleaseRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Release> releaseOptional = releaseRepository.findById(uuid);
        if (releaseOptional.isEmpty()) {
            throw new NotFoundException(Release.class, "id", id);
        }
        Release newEntity = releaseMapper.toReleaseEntity(request);
        newEntity.setId(uuid);
        releaseRepository.save(newEntity);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Release> releaseOptional = releaseRepository.findById(uuid);
        if (releaseOptional.isEmpty()) {
            throw new NotFoundException(Release.class, "id", id);
        }
        releaseRepository.deleteById(uuid);
        return true;
    }
}
