package com.kvnbg.api.controller.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserUpdateRecord(String password, String email) {
}
