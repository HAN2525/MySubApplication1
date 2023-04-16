package com.dicoding.picodiploma.mysubapplication


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.mysubapplication.DetailActivity
import com.dicoding.picodiploma.mysubapplication.R



class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UniversityAdapter
private val list = ArrayList<University>()


    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        list.addAll(getUniversities())
        showRecyclerList()


        // inisialisasi adapter dan data
        adapter = UniversityAdapter(getUniversities())
        recyclerView.adapter = adapter


        // menambahkan listener pada item di RecyclerView
        /*adapter.setOnItemClickListener(object : UniversityAdapter.OnItemClickListener {
            override fun onItemClicked(position: Int) {
                // membuka activity detail universitas dengan intent
                val intent = Intent(this@MainActivity2, DetailActivity::class.java)
                val data = adapter.getItem(position)
                Log.d("Detail Data", data.name.toString())
                intent.putExtra("university", data)
                startActivity(intent)
            }
        })*/
    }

    private fun showRecyclerList() {

        recyclerView.layoutManager = LinearLayoutManager(this)
        val listuniversitasadapter = UniversityAdapter(list)
        recyclerView.adapter = listuniversitasadapter


        listuniversitasadapter.setOnItemClickCallback(object : UniversityAdapter.OnItemClickCallback{
            override fun onItemClicked(data: University) {
                showselecteduniversity(data)
            }
        })

    }

    private fun showselecteduniversity (university: University){
        val intentdetail = Intent(this@MainActivity2, DetailActivity::class.java)
        intentdetail.putExtra("EXTRADATA", university)
        startActivity(intentdetail)
    }

    private fun getUniversities(): ArrayList<University> {
        // data universitas
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listUniversitas = ArrayList<University>()
        for (i in dataName.indices) {
            val universitas = University (dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listUniversitas.add(universitas)
        }
        return listUniversitas
    }
}
