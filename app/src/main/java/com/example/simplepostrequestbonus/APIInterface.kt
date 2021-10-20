package com.example.recyclerviewfromapibonus


import com.example.simplepostrequestbonus.Names
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers

import retrofit2.http.POST

interface APIInterface {
    @Headers("Content-Type: application/json")
   @POST("/custom-people/")
   fun added(@Body userdat: Names.NamesItem):Call<Names.NamesItem>
}