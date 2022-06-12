package com.shiftkey.codingchallenge.data.model.rest

import com.google.gson.annotations.SerializedName
import com.shiftkey.codingchallenge.data.model.Shift

/*
{
                        "shift_id":3117499,
                        "start_time":"2022-06-15T23:00:00+00:00",
                        "end_time":"2022-06-16T11:00:00+00:00",
                        "normalized_start_date_time":"2022-06-15 18:00:00",
                        "normalized_end_date_time":"2022-06-16 06:00:00",
                        "timezone":"Central",
                        "premium_rate":false,
                        "covid":false,
                        "shift_kind":"Night Shift",
                        "within_distance":20,
                        "facility_type":
                         {
                            "id":8,
                            "name":"Skilled Nursing Facility",
                            "color":"#AF52DE"
                         },
                         "skill":{
                            "id":2,
                            "name":"Long Term Care",
                            "color":"#007AFF"
                         },
                         "localized_specialty":{
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
                         }
                       }
 */
data class ShiftApiShift(
    @SerializedName("shift_id")
    var shiftId: Int = -1,
    @SerializedName("start_time")
    var startTime: String = "",
    @SerializedName("end_time")
    var endTime: String = "",
    @SerializedName("normalized_start_date_time")
    var normalizedStartDateTime: String = "",
    @SerializedName("normalized_end_date_time")
    var normalizedEndDateTime: String = "",
    @SerializedName("timezone")
    var timezone: String = "",
    @SerializedName("premium_rate")
    var premiumRate: Boolean = false,
    @SerializedName("covid")
    var covid: Boolean = false,
    @SerializedName("shift_kind")
    var shiftKind: String = "",
    @SerializedName("within_distance")
    var withinDistance: Int = -1,
    @SerializedName("localized_specialty")
    var localizedSpecialty: ShiftApiLocalizedSpecialty? = null

    // TODO
    //var facilityType: String? = null,
    //var skill: String? = null
)