package me.chowlong.smolbackend.ip;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import me.chowlong.smolbackend.url.URL;

import java.util.List;

@Getter
@Entity
public class IP {
    @Id
    private String id;

    @OneToMany(mappedBy = "ip")
    private List<URL> urls;

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IP [id=" + id + "]";
    }
}
