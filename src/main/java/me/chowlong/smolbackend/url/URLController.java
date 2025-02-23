package me.chowlong.smolbackend.url;

import me.chowlong.smolbackend.url.dto.CreateURLRequestDTO;
import me.chowlong.smolbackend.url.dto.EditURLRequestDTO;
import me.chowlong.smolbackend.url.dto.URLResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urls")
public class URLController {
    private final URLService urlService;

    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    /** GET REQUESTS */

    @GetMapping("/ip/{ip}")
    public ResponseEntity<List<URLResponseDTO>> getUrls(@PathVariable("ip") String ip) {
         try {
             List<URL> results = this.urlService.getUrlsById(ip);
             return ResponseEntity.ok(results.stream().map(URLResponseDTO::new).toList());
         }
         catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }

    @GetMapping("/custom-link/{customLink}")
    public ResponseEntity<Boolean> checkUrlExistsByCustomLink(@PathVariable("customLink") String customLink) {
        try {
            return ResponseEntity.ok(this.urlService.existsByCustomLink(customLink));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/name-and-ip/{name}/{ip}")
    public ResponseEntity<Boolean> checkUrlExistsByNameAndIp(@PathVariable("name") String name, @PathVariable("ip") String ip) {
        try {
            return ResponseEntity.ok(this.urlService.existsByNameAndIp(name, ip));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /** POST REQUESTS */

    @PostMapping("/create-url")
    public ResponseEntity createUrl(@RequestBody @Validated CreateURLRequestDTO requestDTO) {
        try {
            this.urlService.createUrl(requestDTO);
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /** PATCH REQUESTS */

    @PatchMapping("/edit-url")
    public ResponseEntity editUrl(@RequestBody @Validated EditURLRequestDTO requestDTO) {
        try {
            this.urlService.editUrl(requestDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /** DELETE REQUESTS */

    @DeleteMapping("/delete-url/{id}")
    public ResponseEntity deleteUrl(@PathVariable("id") Long id) {
        try {
            this.urlService.deleteUrl(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
