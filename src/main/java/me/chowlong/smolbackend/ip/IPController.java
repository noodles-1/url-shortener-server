package me.chowlong.smolbackend.ip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IPController {
    private IPService ipService;

    public IPController(IPService ipService) {
        this.ipService = ipService;
    }

    @GetMapping("/{id}")
    public IP getIPById(@PathVariable String id) throws Exception {
        return ipService.findById(id);
    }
}
