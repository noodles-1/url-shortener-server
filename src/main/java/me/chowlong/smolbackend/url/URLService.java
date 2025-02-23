package me.chowlong.smolbackend.url;

import me.chowlong.smolbackend.ip.IP;
import me.chowlong.smolbackend.ip.IPRepository;
import me.chowlong.smolbackend.url.dto.CreateURLRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class URLService {
    private final URLRepository urlRepository;
    private final IPRepository ipRepository;

    public URLService(URLRepository urlRepository, IPRepository ipRepository) {
        this.urlRepository = urlRepository;
        this.ipRepository = ipRepository;
    }

    public List<URL> getUrlsById(String ip) {
        return this.urlRepository.findByIp_Id(ip);
    }

    public void createUrl(CreateURLRequestDTO requestDTO) throws URLNotCreatedException {
        IP ip = this.ipRepository.findById(requestDTO.getIpId())
                .orElseThrow(() -> new URLNotCreatedException());

        URL newUrl = new URL();
        newUrl.setName(requestDTO.getName());
        newUrl.setLink(requestDTO.getLink());
        newUrl.setCustomLink(requestDTO.getCustomLink());
        newUrl.setIp(ip);

        this.urlRepository.save(newUrl);
    }
}
