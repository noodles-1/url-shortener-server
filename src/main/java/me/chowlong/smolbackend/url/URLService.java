package me.chowlong.smolbackend.url;

import me.chowlong.smolbackend.common.CommonUtils;
import me.chowlong.smolbackend.ip.IP;
import me.chowlong.smolbackend.ip.IPRepository;
import me.chowlong.smolbackend.ip.exception.IPNotFoundException;
import me.chowlong.smolbackend.url.dto.CreateURLRequestDTO;
import me.chowlong.smolbackend.url.dto.EditURLRequestDTO;
import me.chowlong.smolbackend.url.exception.URLNotFoundException;
import org.springframework.stereotype.Service;

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
        return this.urlRepository.findByIp_Id(ip).reversed();
    }

    public URL getUrlByCustomLink(String customLink) {
        return this.urlRepository.findByCustomLink(customLink);
    }

    public Boolean existsByCustomLink(String customLink) {
        return this.urlRepository.existsByCustomLinkLikeIgnoreCase(customLink);
    }

    public Boolean existsByNameAndIp(String name, String ip) {
        return this.urlRepository.existsByNameAndIp_Id(name, ip);
    }

    public void createUrl(CreateURLRequestDTO requestDTO) throws IPNotFoundException {
        IP ip = this.ipRepository.findById(requestDTO.getIpId())
                .orElseThrow(IPNotFoundException::new);

        URL newUrl = new URL();
        newUrl.setName(requestDTO.getName());
        newUrl.setLink(requestDTO.getLink());
        newUrl.setCustomLink(requestDTO.getCustomLink() == null ? CommonUtils.generateCustomLink() : requestDTO.getCustomLink());
        newUrl.setIp(ip);

        this.urlRepository.save(newUrl);
    }

    public void editUrl(EditURLRequestDTO requestDTO) throws URLNotFoundException {
        URL url = this.urlRepository.findById(requestDTO.getId())
                .orElseThrow(URLNotFoundException::new);

        url.setName(requestDTO.getNewName());
        url.setLink(requestDTO.getNewLink());
        url.setCustomLink(requestDTO.getNewCustomLink() == null ? CommonUtils.generateCustomLink() : requestDTO.getNewCustomLink());

        this.urlRepository.save(url);
    }

    public void deleteUrl(Long id) {
        this.urlRepository.deleteById(id);
    }
}
