package me.chowlong.smolbackend.url;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.chowlong.smolbackend.ip.IP;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    private String link;

    @Nullable
    private String customLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ip_id")
    private IP ip;
}
