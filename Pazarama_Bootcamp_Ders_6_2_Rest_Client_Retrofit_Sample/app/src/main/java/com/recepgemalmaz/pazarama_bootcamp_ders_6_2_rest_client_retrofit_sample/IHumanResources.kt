package com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample

import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models.Employee
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models.Employees
import retrofit2.Call
import retrofit2.http.GET

interface IHumanResources {

    @GET("/api/v1/employees")
    public fun getEmployees(): Call<Employees>


}