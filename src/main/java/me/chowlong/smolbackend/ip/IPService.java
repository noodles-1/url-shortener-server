package me.chowlong.smolbackend.ip;

import me.chowlong.smolbackend.ip.dto.CreateIPRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class IPService {
    private final IPRepository ipRepository;

    public IPService(IPRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    public IP findById(String ip) throws IPNotFoundException {
        Optional<IP> result = this.ipRepository.findById(ip);
        if (result.isEmpty())
            throw new IPNotFoundException();
        return result.get();
    }

    public void createIp(CreateIPRequestDTO requestDTO) {
        IP newIp = new IP();
        newIp.setId(requestDTO.getIp());
        this.ipRepository.save(newIp);
    }
}
