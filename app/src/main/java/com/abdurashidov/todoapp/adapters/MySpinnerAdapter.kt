package com.abdurashidov.todoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.abdurashidov.todoapp.R
import com.abdurashidov.todoapp.databinding.SpinnerItemBinding
import com.abdurashidov.todoapp.models.SpinnerItem

class MySpinnerAdapter(val list:ArrayList<SpinnerItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView:SpinnerItemBinding
        itemView=SpinnerItemBinding.inflate(LayoutInflater.from(parent?.context))

        if (list[position].image!=-1){
            itemView.spinnerImg.setImageResource(list[position].image)
        }
        itemView.spinnerTv.text=list[position].degree

        return itemView.root
    }
}