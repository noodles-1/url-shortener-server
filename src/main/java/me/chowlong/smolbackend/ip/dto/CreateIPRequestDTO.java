package me.chowlong.smolbackend.ip.dto;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class CreateIPRequestDTO {
    @Nonnull
    private String ip;
}
