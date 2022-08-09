package com.abdurashidov.todoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.todoapp.R
import com.abdurashidov.todoapp.databinding.ActivityInfoBinding
import com.abdurashidov.todoapp.models.Todo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class InfoActivity : AppCompatActivity() {

    lateinit var binding:ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val obj=intent.getStringExtra("obj")
            val type=object : TypeToken<Todo>(){}.type
            val todo=Gson().fromJson<Todo>(obj, type)

            description.text=todo.description
            degreeImg.setImageResource(todo.degreePicture.toInt())
            degree.text=todo.degree
            createDate.text=todo.createDate
            deadline.text=todo.deadline

            val checkId=todo.checkboxId

        }

    }
}