package com.example.worker.rabbit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CustomMessage(@JsonProperty("file") String text,
                            @JsonProperty("progress") int progress) implements Serializable {}

