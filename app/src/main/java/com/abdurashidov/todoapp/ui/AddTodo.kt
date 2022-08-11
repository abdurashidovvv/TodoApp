package com.abdurashidov.todoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.abdurashidov.todoapp.Cache.MySharedPreference
import com.abdurashidov.todoapp.R
import com.abdurashidov.todoapp.adapters.MySpinnerAdapter
import com.abdurashidov.todoapp.databinding.ActivityAddTodoBinding
import com.abdurashidov.todoapp.models.SpinnerItem
import com.abdurashidov.todoapp.models.Todo
import com.abdurashidov.todoapp.models.TodoList

class AddTodo : AppCompatActivity() {

    lateinit var binding: ActivityAddTodoBinding
    lateinit var listSpinner:ArrayList<SpinnerItem>
    lateinit var mySpinnerAdapter: MySpinnerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listSpinner=ArrayList()
        listSpinner.add(SpinnerItem("To do degree", -1))
        listSpinner.add(SpinnerItem("Urgent", R.drawable.reg_flag))
        listSpinner.add(SpinnerItem("High", R.drawable.yellow_flag))
        listSpinner.add(SpinnerItem("Normal", R.drawable.blue_flag))
        listSpinner.add(SpinnerItem("Low", R.drawable.gray_flag))

        mySpinnerAdapter= MySpinnerAdapter(listSpinner)
        binding.spinner.adapter=mySpinnerAdapter


        val name=binding.edt1.text
        val description=binding.edt2.text
        val createDate=binding.edt3.text
        val deadline=binding.edt4.text
        val checkboxId=0
        var degree=""
        var degreeImg=0

        binding.spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                degree=listSpinner[position].degree
                degreeImg=listSpinner[position].image
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        MySharedPreference.init(this)

        binding.btn1.setOnClickListener {
            if (name.isEmpty() || description.isEmpty() || createDate.isEmpty() || deadline.isEmpty() || degree.isEmpty() || degreeImg==-1){
                Toast.makeText(this, "Hamma maydonlarni to'ldiring.!", Toast.LENGTH_SHORT).show()
            }else{
                TodoList.todoList.add(Todo("$name", "$description", "$degree", "$degreeImg", "$createDate", "$deadline", "$checkboxId"))
                MySharedPreference.obektString=TodoList.todoList
                finish()
            }
        }

    }
}