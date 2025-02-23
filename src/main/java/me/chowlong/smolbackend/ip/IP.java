package me.chowlong.smolbackend.ip;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class IP {
    @Id
    private String id;

    @Override
    public String toString() {
        return "IP [id=" + id + "]";
    }
}
