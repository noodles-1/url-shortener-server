package me.chowlong.smolbackend.ip;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IPController {
    private IPService ipService;

    public IPController(IPService ipService) {
        this.ipService = ipService;
    }

    /** GET REQUESTS */

    @GetMapping("/{ip}")
    public ResponseEntity checkIpExists(@PathVariable("ip") String ip) {
        try {
            this.ipService.findById(ip);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /** POST REQUESTS */

    @PostMapping("/create-ip")
    public ResponseEntity createIp(@RequestBody String ip) {
        try {
            this.ipService.createIp(ip);
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
