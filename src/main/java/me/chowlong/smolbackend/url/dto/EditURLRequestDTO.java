package me.chowlong.smolbackend.url.dto;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class EditURLRequestDTO {
    @Nonnull
    private Long id;

    @Nonnull
    private String newName;

    @Nonnull
    private String newLink;

    @Nullable
    private String newCustomLink;
}
