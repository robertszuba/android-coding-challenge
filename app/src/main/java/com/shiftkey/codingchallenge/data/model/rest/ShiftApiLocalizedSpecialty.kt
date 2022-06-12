package com.shiftkey.codingchallenge.data.model.rest

import com.google.gson.annotations.SerializedName

/*
                            "id":44,
                            "specialty_id":6,
                            "state_id":44,
                            "name":"Certified Nursing Aide",
                            "abbreviation":"CNA",
                            "specialty":{
                                "id":6,
                                "name":"Certified Nursing Aide",
                                "color":"#007AFF",
                                "abbreviation":"CNA"
                             }
 */
data class ShiftApiLocalizedSpecialty(
    @SerializedName("id")
    var id: Int = -1,
    @SerializedName("specialty_id")
    var specialtyId : Int = -1,
    @SerializedName("state_id")
    var stateId: Int = -1,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("abbreviation")
    var abbreviation: String = "",
    @SerializedName("specialty")
    var specialty: ShiftApiSpecialty? = null
)