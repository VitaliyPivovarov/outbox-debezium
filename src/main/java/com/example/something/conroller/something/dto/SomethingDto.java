package com.example.something.conroller.something.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SomethingDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
