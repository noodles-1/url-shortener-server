package me.chowlong.smolbackend.url;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class URLService {
    private URLRepository urlRepository;

    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<URL> getUrlsById(String ip) {
        return this.urlRepository.findByIp_Id(ip);
    }
}
