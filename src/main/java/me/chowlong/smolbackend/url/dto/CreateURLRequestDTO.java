package me.chowlong.smolbackend.url.dto;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class CreateURLRequestDTO {
    @Nonnull
    private String name;

    @Nonnull
    private String link;

    @Nullable
    private String customLink;

    @Nonnull
    private String ipId;
}
