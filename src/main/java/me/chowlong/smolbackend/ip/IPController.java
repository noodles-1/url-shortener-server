package me.chowlong.smolbackend.ip;

import me.chowlong.smolbackend.ip.dto.CreateIPRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ips")
public class IPController {
    private final IPService ipService;

    public IPController(IPService ipService) {
        this.ipService = ipService;
    }

    /** GET REQUESTS */

    @GetMapping("/{ip}")
    public ResponseEntity<Boolean> checkIpExists(@PathVariable("ip") String ip) {
        try {
            return ResponseEntity.ok(this.ipService.existsById(ip));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /** POST REQUESTS */

    @PostMapping("/create-ip")
    public ResponseEntity createIp(@RequestBody @Validated CreateIPRequestDTO requestDTO) {
        try {
            this.ipService.createIp(requestDTO);
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
