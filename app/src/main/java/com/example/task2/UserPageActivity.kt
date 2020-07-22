package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_user_page.*
import kotlinx.android.synthetic.main.item_person.view.*

class UserPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)
        var person = intent.getParcelableExtra<Person>("positionPerson")
        Glide.with(imageUser.context).load(person?.urlImage)
           .into(imageUser.civPersonImage)
        tvName.text = person?.name

    }
}