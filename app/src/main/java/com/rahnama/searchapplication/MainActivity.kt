package com.rahnama.searchapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahnama.searchapplication.databinding.ActivityMainBinding
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast

import java.util.ArrayList




private  lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter:ArrayAdapter<String>

        val city=ArrayList<String>()
        city.add("تهران")
        city.add("مشهد")
        city.add("فردوس")
        city.add("یزد")
        city.add("قم")
        city.add("شیراز")
        city.add("کرج")
        city.add("بندرعباس")
        city.add("قوچان")
        city.add("چالوس")

       adapter= ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,city)
       binding.listView.adapter=adapter

    /*****************************************************/
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(city.contains(query)){
                    adapter.filter.filter(query)
                }else{
                    Toast.makeText(applicationContext, "موردی یافت نشد", Toast.LENGTH_LONG).show()
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }


        })
        /*****************************************************/
    }
}