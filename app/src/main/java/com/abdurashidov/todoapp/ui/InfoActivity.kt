package com.abdurashidov.todoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.todoapp.R
import com.abdurashidov.todoapp.databinding.ActivityInfoBinding
import com.abdurashidov.todoapp.models.Todo
import com.abdurashidov.todoapp.models.TodoList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class InfoActivity : AppCompatActivity() {

    lateinit var binding:ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onStart() {
        super.onStart()
        binding.apply {

            val obj=intent.getStringExtra("obj")
            val type=object : TypeToken<Todo>(){}.type
            val todo=Gson().fromJson<Todo>(obj, type)

            description.text="${description.text} \n ${todo.description}"
            degreeImg.setImageResource(todo.degreePicture.toInt())
            degree.text=todo.degree
            createDate.text="${createDate.text} \n ${todo.createDate}"
            deadline.text="${deadline.text} \n ${todo.deadline}"


            radioGroup.check(todo.checkboxId.toInt()+1)

            TodoList.todoList.remove(todo)

            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when(checkedId){
                    1->todo.checkboxId="0"
                    2->todo.checkboxId="1"
                    3->todo.checkboxId="2"
                    4->todo.checkboxId="3"
                    5->todo.checkboxId="4"
                }
                TodoList.todoList.add(todo)
            }
            btn1.setOnClickListener {
                finish()
            }
        }
    }
}