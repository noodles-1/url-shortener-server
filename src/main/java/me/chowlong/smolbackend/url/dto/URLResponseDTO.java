package me.chowlong.smolbackend.url.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chowlong.smolbackend.url.URL;

@Getter
@NoArgsConstructor
public class URLResponseDTO {
    private Long id;
    private String name;
    private String link;
    private String customLink;

    public URLResponseDTO(URL url) {
        if (url != null) {
            this.id = url.getId();
            this.name = url.getName();
            this.link = url.getLink();
            this.customLink = url.getCustomLink();
        }
    }
}
