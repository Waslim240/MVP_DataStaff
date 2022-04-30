package waslim.binar.andlima.tugasmvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.staff_item.view.*
import waslim.binar.andlima.tugasmvp.R
import waslim.binar.andlima.tugasmvp.model.GetAllStaffResponseItem

class AdapterStaff(private var dataStaff : List<GetAllStaffResponseItem>, private var onClickDetail : (GetAllStaffResponseItem) -> Unit) : RecyclerView.Adapter<AdapterStaff.ViewHolder> (){

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterStaff.ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.staff_item, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterStaff.ViewHolder, position: Int) {
        holder.itemView.nameStaff.text = dataStaff[position].name
        holder.itemView.emailStaff.text = dataStaff[position].email
        Glide.with(holder.itemView.context).load(dataStaff[position].image).into(holder.itemView.imageViewStaff)

        holder.itemView.cardDetailStaff.setOnClickListener {
            onClickDetail(dataStaff[position])
        }

    }

    override fun getItemCount(): Int {
        return dataStaff.size
    }

}