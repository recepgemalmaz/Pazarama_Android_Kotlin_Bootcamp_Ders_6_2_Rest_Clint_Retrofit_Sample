package com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample

import android.util.Log
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models.Employee
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models.Employees
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*

class ServiceRepository {

    companion object {
        private val BASE_URL = "https://dummy.restapiexample.com"

        private val client: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private val proxy: IHumanResources by lazy {
            client.create(IHumanResources::class.java)
        }
    }

        public fun GetEmployees() :MutableList<Employee> {
            val lst = mutableListOf<Employee>()

            proxy.getEmployees().enqueue(
                object : Callback<Employees> {
                    override fun onResponse(call: Call<Employees>, response: Response<Employees>) {
                        response.body()?.data?.forEach {
                            Log.e("err", "${it.employee_name} ${it.employee_age} ${it.employee_salary}")
                            lst.add(it)
                        }
                    }

                    override fun onFailure(call: Call<Employees>, t: Throwable) {
                        Log.e("err", t.message.toString())
                    }
                }
            )
            return lst!!
        }

}

 */




class ServiceRepository {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://dummy.restapiexample.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var proxy: IHumanResources = retrofit.create(IHumanResources::class.java)

    public fun GetEmployees() :MutableList<Employee> {

        var lst = mutableListOf<Employee>()

        proxy.getEmployees().enqueue(
            object : Callback<Employees>
            {
                override fun onResponse(call: Call<Employees>, response: Response<Employees>)
                {

                    response.body()!!.data!!.forEach {
                        Log.e("err", it.employee_name + " " + it.employee_age.toString()+ " " + it.employee_salary.toString())
                        lst.add(it)
                    }

                }

                override fun onFailure(call: Call<Employees>, t: Throwable)
                {
                    Log.e("err", t.message.toString())
                }

            }
        )
        return lst!!
    }
}

