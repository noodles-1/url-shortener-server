package me.chowlong.smolbackend.ip;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPService {
    private IPRepository ipRepository;

    public IPService(IPRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    public IP findById(String ip) throws IPNotFoundException {
        Optional<IP> result = ipRepository.findById(ip);
        if (result.isEmpty())
            throw new IPNotFoundException();
        return result.get();
    }

    public void createIp(String ip) throws IPNotCreatedException {
        try {
            IP newIp = new IP();
            newIp.setId(ip);
            this.ipRepository.save(newIp);
        }
        catch (Exception e) {
            throw new IPNotCreatedException();
        }
    }
}
