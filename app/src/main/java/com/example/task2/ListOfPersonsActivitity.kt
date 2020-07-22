package com.example.task2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task2.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_list_of_persons.*
import kotlinx.android.synthetic.main.item_person.*
//
//class ListOfPersonsActivitity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_list_of_persons)
//        var person = initializationPeople()
//        val adapter = PeopleListAdapter(person)
//        adapter.setOnItemClickListener(object : PeopleListAdapter.OnItemClickListener {
//            override fun onClick(position: Int) {
//                val intent = Intent(tvUser.context, UserPageActivity::class.java)
//                intent.putExtra("positionPerson", person[position])
//                tvUser.context.startActivity(intent)
//            }
//        })
//        rvPersons.adapter = adapter
//        rvPersons.layoutManager = LinearLayoutManager(this)
//    }
//    //Метод
//    private fun adapterItemClick (item: PeopleListAdapter) {
//        //что то делаем с вашим Subject
//    }
//    fun initializationPeople(): List<Person> {
//        val people: List<Person> = mutableListOf(Person("Svetlana", "Beryozkina", 26,
//            "https://sonniki.name/wp-content/uploads/2019/09/d0b4d0b5d0b2d183d188d0bad0b0.jpg" )
//        , Person("Nikita", "Vodov", 16,
//                "https://avatars.mds.yandex.net/get-pdb/1808037/5ff840c4-88a0-46d9-8c68-4670ecc57531/s600")
//        )
//        return people
//    }
//}

class ListOfPersonsActivitity : AppCompatActivity() {

    private val adapter =PeopleListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_persons)
      //  var team = loadTeams()
      //  val adapter = PeopleListAdapter(person)
//        adapter.setOnItemClickListener(object : PeopleListAdapter.OnItemClickListener {
//            override fun onClick(position: Int) {
//                val intent = Intent(tvUser.context, UserPageActivity::class.java)
//                //intent.putExtra("positionPerson", person[position])
//                tvUser.context.startActivity(intent)
//            }
        rvPersons.adapter = adapter
        rvPersons.layoutManager = LinearLayoutManager(this)
        loadTeams()
    }
    private fun loadTeams() {
        ApiClient.instance.mainApi.getTeams()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapter.setTeams(it.data!!)
            }, {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            })
    }
    //Метод
    private fun adapterItemClick (item: PeopleListAdapter) {
        //что то делаем с вашим Subject
    }
    fun initializationPeople(): List<Person> {
        val people: List<Person> = mutableListOf(Person("Svetlana", "Beryozkina", 26,
            "https://sonniki.name/wp-content/uploads/2019/09/d0b4d0b5d0b2d183d188d0bad0b0.jpg" )
            , Person("Nikita", "Vodov", 16,
                "https://avatars.mds.yandex.net/get-pdb/1808037/5ff840c4-88a0-46d9-8c68-4670ecc57531/s600")
        )
        return people
    }
}