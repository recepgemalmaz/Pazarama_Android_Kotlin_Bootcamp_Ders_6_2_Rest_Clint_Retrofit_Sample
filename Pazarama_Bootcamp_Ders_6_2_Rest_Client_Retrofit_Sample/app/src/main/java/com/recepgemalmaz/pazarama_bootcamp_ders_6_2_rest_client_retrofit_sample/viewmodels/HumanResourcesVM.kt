package com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models.Employee
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.ServiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HumanResourcesVM (sr: ServiceRepository): ViewModel(){

    private var repository: ServiceRepository? = null
    init {
        this.repository = sr
    }

    public var Department:List<Employee>? = null
        get() = this.repository?.GetEmployees()



    fun GetList() : Flow<List<Employee>?>
    {
        var f = flow<List<Employee>?> {

            Log.e("err", Department?.get(0)?.employee_name?: "null")
            emit(Department)
        }
        return f
    }
}