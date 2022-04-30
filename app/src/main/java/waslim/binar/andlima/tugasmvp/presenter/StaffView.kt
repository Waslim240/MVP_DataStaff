package waslim.binar.andlima.tugasmvp.presenter

import waslim.binar.andlima.tugasmvp.model.GetAllStaffResponseItem

interface StaffView {

    fun onSuccess(pesan : String, staff : List<GetAllStaffResponseItem>)
    fun onError(pesan : String)

}