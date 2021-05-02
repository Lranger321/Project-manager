package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseAddResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseDeleteResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseResponse;
import com.simbirsoft.projectManager.dto.response.releases.ReleaseUpdateResponse;
import com.simbirsoft.projectManager.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление релизами")
@RestController
@RequestMapping("/api/releases")
public class ReleaseController {

    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(summary = "Получить релиз по id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponse> getReleaseById (@PathVariable String id) {
        return new ResponseEntity<>(releaseService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Добавить релиз")
    @PostMapping(value = "/")
    public ResponseEntity<ReleaseAddResponse> addRelease (ReleaseRequest request) {
        return new ResponseEntity<>(releaseService.addRelease(request), HttpStatus.OK);
    }

    @Operation(summary = "Обновить данные о релизе")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReleaseUpdateResponse> updateRelease (@PathVariable String id,
                                                                ReleaseRequest request) {
        return new ResponseEntity<>(releaseService.updateRelease(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ReleaseDeleteResponse> deleteRelease (@PathVariable String id) {
        return new ResponseEntity<>(releaseService.deleteById(id), HttpStatus.OK);
    }
}
