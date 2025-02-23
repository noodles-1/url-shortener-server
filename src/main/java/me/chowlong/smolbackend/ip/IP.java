package me.chowlong.smolbackend.ip;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import me.chowlong.smolbackend.url.URL;

import java.util.List;

@Getter
@Entity
public class IP {
    @Setter
    @Id
    private String id;

    @OneToMany(mappedBy = "ip")
    private List<URL> urls;

    @Override
    public String toString() {
        return "IP [id=" + id + "]";
    }
}
