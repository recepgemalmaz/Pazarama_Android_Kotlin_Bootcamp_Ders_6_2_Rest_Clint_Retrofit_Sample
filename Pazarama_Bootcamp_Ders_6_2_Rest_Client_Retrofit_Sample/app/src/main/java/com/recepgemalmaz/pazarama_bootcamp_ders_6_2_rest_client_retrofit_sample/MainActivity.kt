package com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.Models.Employee
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.ui.theme.Pazarama_Bootcamp_Ders_6_2_Rest_Client_Retrofit_SampleTheme
import com.recepgemalmaz.pazarama_bootcamp_ders_6_2_rest_client_retrofit_sample.viewmodels.HumanResourcesVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vm: HumanResourcesVM = HumanResourcesVM(ServiceRepository())

        setContent {
            Pazarama_Bootcamp_Ders_6_2_Rest_Client_Retrofit_SampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EmployeesListDisplay(lst = vm.GetList().collectAsState(
                        initial = emptyList<Employee>()) .value!!)
                }
            }
        }
    }
}

@Composable
fun EmployeeDisplay(e: Employee) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Blue)
    ) {
        Text(text = e.employee_name)
        Spacer(
            modifier = Modifier
                .width(5.dp)
                .height(5.dp)
        )
        Text(text = "Age: " + e.employee_age.toString())
        Spacer(
            modifier = Modifier
                .width(5.dp)
                .height(5.dp)
        )
        Text(text = "Salary: " + e.employee_salary.toString())
    }

}

@Composable
fun EmployeesListDisplay(lst: List<Employee>) {
    LazyColumn(contentPadding = PaddingValues(5.dp), userScrollEnabled = true)
    {
        this.items(lst)
        {
            EmployeeDisplay(e = it)
        }
    }
}

