package com.example.testnetworklibs.entity

import br.com.tembici.characters.list.data.entity.Character
import com.fasterxml.jackson.annotation.JsonProperty

class CharactersResponse {
    @field:JsonProperty("results")
    var results: List<Character>? = null

    @field:JsonProperty("info")
    var info: Info? = null

    override fun toString(): String {
        return "CharactersResponse{" +
                "results = '" + results + '\'' +
                ",info = '" + info + '\'' +
                "}"
    }
}