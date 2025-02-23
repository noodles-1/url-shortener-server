package me.chowlong.smolbackend.ip;

import me.chowlong.smolbackend.ip.dto.CreateIPRequestDTO;
import me.chowlong.smolbackend.ip.exception.IPNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPService {
    private final IPRepository ipRepository;

    public IPService(IPRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    public Boolean existsById(String ip) {
        return this.ipRepository.existsById(ip);
    }

    public void createIp(CreateIPRequestDTO requestDTO) {
        IP newIp = new IP();
        newIp.setId(requestDTO.getIp());
        this.ipRepository.save(newIp);
    }
}
