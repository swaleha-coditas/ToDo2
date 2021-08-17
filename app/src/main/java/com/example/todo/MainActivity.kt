package com.example.todo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context = context

        private val names = arrayListOf(
            "Make Presentation",
            "Go for a walk",
            "Buy Fruits",
            "Attend the meeting",
            "Prepare dinner"
        )

            override fun getCount(): Int {
            return names.size
        }

            override fun getItemId(position: Int): Long {
            return position.toLong()
        }


        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }


            override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            names[position].also { nameTextView.text = it }

            return rowMain
        }

    }
}
