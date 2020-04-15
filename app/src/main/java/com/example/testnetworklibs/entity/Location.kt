package com.example.testnetworklibs.entity

import com.fasterxml.jackson.annotation.JsonProperty

class Location {
    @field:JsonProperty("name")
    var name: String? = null

    @field:JsonProperty("url")
    var url: String? = null

    override fun toString(): String {
        return "Location{" +
                "name = '" + name + '\'' +
                ",url = '" + url + '\'' +
                "}"
    }
}