package com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models

data class Employee(
    val employee_age: Int,
    val employee_name: String,
    val employee_salary: Int,
    val id: Int,
    val profile_image: String
)

data class Employees(
    var status: String?,
    var message: String?,
    var data: List<Employee>?
)