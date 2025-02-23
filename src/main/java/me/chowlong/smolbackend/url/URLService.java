package me.chowlong.smolbackend.url;

import org.springframework.stereotype.Service;

@Service
public class URLService {
    private URLRepository urlRepository;

    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }
}
