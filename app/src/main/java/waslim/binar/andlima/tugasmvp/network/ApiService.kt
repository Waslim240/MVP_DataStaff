package waslim.binar.andlima.tugasmvp.network

import retrofit2.Call
import retrofit2.http.GET
import waslim.binar.andlima.tugasmvp.model.GetAllStaffResponseItem

interface ApiService {

    @GET("staf")
    fun getAllNews() : Call<List<GetAllStaffResponseItem>>

}