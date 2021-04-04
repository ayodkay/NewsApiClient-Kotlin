package com.github.ayodkay.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


data class SourcesResponse (
    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("sources")
    @Expose
    var sources: List<Source>
)