package proyecto.pontificia.mi.registroadmision.api.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proyecto.pontificia.mi.registroadmision.api.services.FileSystemStorageServiceImpl;
import proyecto.pontificia.mi.registroadmision.api.utils.Response;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/static")
public class StaticController {
    private final FileSystemStorageServiceImpl storageService;

    public StaticController(FileSystemStorageServiceImpl storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file) {
        Response response = new Response();
        try {
            String filename = storageService.store(file);

            Map<String, String> result = new HashMap<>();
            result.put("filename", filename);

            response.setCodigoRespuesta(200);
            response.setMensajeRespuesta("Operación correcta");
            response.setData(result);
        } catch (Exception e) {
            response.setCodigoRespuesta(500);
            response.setMensajeRespuesta("Error en la operación: " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    @GetMapping("/{filename:.+}")
    ResponseEntity<Resource> load(@PathVariable String filename) throws IOException {
        Resource resource = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(resource.getFile().toPath());
        return  ResponseEntity
                .ok()
                .header("Content-Type", contentType)
                .body(resource);
    }

}
