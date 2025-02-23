package me.chowlong.smolbackend.url;

import me.chowlong.smolbackend.url.dto.CreateURLRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urls")
public class URLController {
    private URLService urlService;

    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    /** GET REQUESTS */

    @GetMapping("/{ip}")
    public ResponseEntity<List<URL>> getUrls(@PathVariable("ip") String ip) {
         try {
             return new ResponseEntity<>(this.urlService.getUrlsById(ip), HttpStatus.OK);
         }
         catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    /** POST REQUESTS */

    @GetMapping("/create-url")
    public ResponseEntity createUrl(@RequestBody @Validated CreateURLRequestDTO requestDTO) {
        try {
            this.urlService.createUrl(requestDTO);
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
