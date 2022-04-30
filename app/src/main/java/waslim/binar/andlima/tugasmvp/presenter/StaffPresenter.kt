package waslim.binar.andlima.tugasmvp.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.tugasmvp.model.GetAllStaffResponseItem
import waslim.binar.andlima.tugasmvp.network.ApiClient

class StaffPresenter(private val staffView: StaffView) {

    fun getDataStaff(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllStaffResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllStaffResponseItem>>,
                    response: Response<List<GetAllStaffResponseItem>>
                ) {
                    if (response.isSuccessful){
                        staffView.onSuccess(response.message(), response.body()!!)
                    } else {
                        staffView.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllStaffResponseItem>>, t: Throwable) {
                    staffView.onError(t.message!!)
                }

            })
    }

}