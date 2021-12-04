package com.example.videosteamcore.rabbit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CustomMessage(@JsonProperty("file") String file,
                            @JsonProperty("progress") int progress) implements Serializable {}

