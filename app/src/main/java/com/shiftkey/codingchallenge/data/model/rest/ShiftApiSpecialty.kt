package com.shiftkey.codingchallenge.data.model.rest

import com.google.gson.annotations.SerializedName

/*
                            "specialty":{
                                "id":6,
                                "name":"Certified Nursing Aide",
                                "color":"#007AFF",
                                "abbreviation":"CNA"
                             }
 */
data class ShiftApiSpecialty(
    @SerializedName("id")
    var id: Int = -1,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("color")
    var color: String = "",
    @SerializedName("abbreviation")
    var abbreviation: String = ""
)