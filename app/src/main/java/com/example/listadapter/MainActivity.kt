package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listAdapter: NewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         listAdapter = NewAdapter()
        val list = mutableListOf<User>()
        list.add(User("1","mot"))
        list.add(User("2","hai"))
        list.add(User("3","ba"))
        list.add(User("4","bon"))
        list.add(User("5","nam"))
        list.add(User("6","sau"))
       // bind.lifecyclerowner = this
        listAdapter.submitList(list)
        recycler.adapter = listAdapter
        recycler.layoutManager = LinearLayoutManager(this)


    }

    var flag = TYPE_ONE

    fun update(v: View) {

        flag = if (flag == TYPE_ONE) TYPE_TWO else TYPE_ONE
        listAdapter.submitList(loadList(flag))
    }
    companion object {
        const val TYPE_ONE = 0
        const val TYPE_TWO = 1
    }

    fun loadList(type: Int): List<User> {
        val list = mutableListOf<User>()
        when (type)  {
            TYPE_ONE ->  {
                list.add(User("1","One"))
                list.add(User("3","ba"))
                list.add(User("9","chin"))
                list.add(User("6","six"))
            }
            TYPE_TWO -> {
                list.add(User("1","mot"))
                list.add(User("2","hai"))
                list.add(User("3","ba"))
                list.add(User("4","bon"))
                list.add(User("5","nam"))
                list.add(User("6","sau"))
            }

        }
        return list
    }

}
