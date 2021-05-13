package com.simbirsoft.projectManager.rest;

import com.simbirsoft.projectManager.rest.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.rest.dto.response.ReleaseResponse;
import com.simbirsoft.projectManager.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Управление релизами")
@RestController
@RequestMapping("/api/releases")
public class ReleaseController {

    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(summary = "Получить релиз по id")
    @GetMapping("/{id}")
    public ResponseEntity<ReleaseResponse> getReleaseById (@PathVariable String id) {
        return ResponseEntity.ok(releaseService.getById(id));
    }

    @Operation(summary = "Добавить релиз")
    @PostMapping("/")
    public ResponseEntity<UUID> addRelease (@RequestBody ReleaseRequest request) {
        return ResponseEntity.ok(releaseService.addRelease(request));
    }

    @Operation(summary = "Обновить данные о релизе")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateRelease (@PathVariable String id,
                                                  @RequestBody ReleaseRequest request) {
        return ResponseEntity.ok(releaseService.updateRelease(id, request));
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRelease (@PathVariable String id) {
        return ResponseEntity.ok(releaseService.deleteById(id));
    }
}
