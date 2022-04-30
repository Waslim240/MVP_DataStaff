package waslim.binar.andlima.tugasmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_detail_staff.*
import waslim.binar.andlima.tugasmvp.R
import waslim.binar.andlima.tugasmvp.model.GetAllStaffResponseItem

class MainDetailStaff : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_detail_staff)

        detail()

    }

    private fun detail(){
        val dataStaff = intent.getParcelableExtra<GetAllStaffResponseItem>("DETAIL_STAFF")

        nameStaff_detail.text = dataStaff?.name
        Glide.with(applicationContext).load(dataStaff?.image).into(imageViewStaff_detail)
        emailStaff_detail.text = dataStaff?.email
        createDate_detail.text = dataStaff?.createdAt

    }

}