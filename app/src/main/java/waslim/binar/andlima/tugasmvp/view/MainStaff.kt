package waslim.binar.andlima.tugasmvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.staff_main.*
import waslim.binar.andlima.tugasmvp.R
import waslim.binar.andlima.tugasmvp.adapter.AdapterStaff
import waslim.binar.andlima.tugasmvp.model.GetAllStaffResponseItem
import waslim.binar.andlima.tugasmvp.presenter.StaffPresenter
import waslim.binar.andlima.tugasmvp.presenter.StaffView

class MainStaff : AppCompatActivity(), StaffView {

    private lateinit var staffPresenter: StaffPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staff_main)

        staffPresenter = StaffPresenter(this)
        staffPresenter.getDataStaff()

    }

    override fun onSuccess(pesan: String, staff: List<GetAllStaffResponseItem>) {
        rvStaff.layoutManager = LinearLayoutManager(this)
        rvStaff.adapter = AdapterStaff(staff){
            val pdh = Intent(this, MainDetailStaff::class.java)
            pdh.putExtra("DETAIL_STAFF", it)
            startActivity(pdh)
        }
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }

}