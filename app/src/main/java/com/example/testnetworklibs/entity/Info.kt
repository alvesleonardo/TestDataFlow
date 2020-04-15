package com.example.testnetworklibs.entity

import com.fasterxml.jackson.annotation.JsonProperty

class Info {
    @field:JsonProperty("next")
    var next: String? = null

    @field:JsonProperty("pages")
    var pages = 0

    @field:JsonProperty("prev")
    var prev: String? = null

    @field:JsonProperty("count")
    var count = 0

    override fun toString(): String {
        return "Info{" +
                "next = '" + next + '\'' +
                ",pages = '" + pages + '\'' +
                ",prev = '" + prev + '\'' +
                ",count = '" + count + '\'' +
                "}"
    }
}