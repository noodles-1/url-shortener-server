package me.chowlong.smolbackend.url;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class URLController {
    private URLService urlService;

    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    /** GET REQUESTS */

    @GetMapping("/get-urls/{ip}")
    public ResponseEntity<List<URL>> getUrls(@PathVariable("ip") String ip) {
         try {
             return new ResponseEntity<>(this.urlService.getUrlsById(ip), HttpStatus.OK);
         }
         catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
}
