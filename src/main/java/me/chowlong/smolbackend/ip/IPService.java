package me.chowlong.smolbackend.ip;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPService {
    private IPRepository ipRepository;

    public IPService(IPRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    public IP findById(String id) throws IPNotFoundException {
        Optional<IP> ip = ipRepository.findById(id);
        if (ip.isEmpty())
            throw new IPNotFoundException();
        return ip.get();
    }
}
