package com.example.testnetworklibs.entity

import com.fasterxml.jackson.annotation.JsonProperty

class Origin {
    @field:JsonProperty("name")
    var name: String? = null

    @field:JsonProperty("url")
    var url: String? = null

    override fun toString(): String {
        return "Origin{" +
                "name = '" + name + '\'' +
                ",url = '" + url + '\'' +
                "}"
    }
}