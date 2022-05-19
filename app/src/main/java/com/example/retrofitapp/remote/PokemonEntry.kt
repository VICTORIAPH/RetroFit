package com.example.retrofitapp.remote

import com.google.gson.annotations.SerializedName

data class PokemonEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("types")
    val type: List<TypeEntry>,
    @SerializedName("stats")
    val stats: List<StatsEntry>,
)

data class TypeEntry(
    @SerializedName("type")
    val type: TypeName
)
data class TypeName(
    @SerializedName("name")
    val name: String
)
data class StatsEntry(
    @SerializedName("base_stat")
    val base_stats: Int,
    @SerializedName("stat")
    val stat: StatsEntry
)
data class StatEntry(
    @SerializedName("name")
    val stat_value: Int
)