package com.kvnbg.api.controller.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserCreateRecord(
        @NotNull String username,
        @NotNull String password,
        @NotNull String email
) {}
