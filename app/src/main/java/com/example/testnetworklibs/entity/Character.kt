package br.com.tembici.characters.list.data.entity

import com.example.testnetworklibs.entity.Location
import com.example.testnetworklibs.entity.Origin
import com.fasterxml.jackson.annotation.JsonProperty

class Character {
    @field:JsonProperty("image")
    var image: String? = null

    @field:JsonProperty("gender")
    var gender: String? = null

    @field:JsonProperty("species")
    var species: String? = null

    @field:JsonProperty("created")
    var created: String? = null

    @field:JsonProperty("origin")
    var origin: Origin? = null

    @field:JsonProperty("name")
    var name: String? = null

    @field:JsonProperty("location")
    var location: Location? = null

    @field:JsonProperty("episode")
    var episode: List<String>? = null

    @field:JsonProperty("id")
    var id = 0

    @field:JsonProperty("type")
    var type: String? = null

    @field:JsonProperty("url")
    var url: String? = null

    @field:JsonProperty("status")
    var status: String? = null

    override fun toString(): String {
        return "Character{" +
                "image = '" + image + '\'' +
                ",gender = '" + gender + '\'' +
                ",species = '" + species + '\'' +
                ",created = '" + created + '\'' +
                ",origin = '" + origin + '\'' +
                ",name = '" + name + '\'' +
                ",location = '" + location + '\'' +
                ",episode = '" + episode + '\'' +
                ",id = '" + id + '\'' +
                ",type = '" + type + '\'' +
                ",url = '" + url + '\'' +
                ",status = '" + status + '\'' +
                "}"
    }
}