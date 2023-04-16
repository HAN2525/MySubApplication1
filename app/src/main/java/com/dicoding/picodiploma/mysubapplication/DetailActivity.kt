package com.dicoding.picodiploma.mysubapplication


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var imgitemphoto : ImageView
    private lateinit var tvitemname : TextView
    private lateinit var tvitemlongdescription : TextView
    private val list = ArrayList<University>()

    override fun onCreate (savedInstanceState : Bundle? ){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_universitas)

        val Univ = intent.getParcelableExtra<University>("EXTRADATA")

        imgitemphoto = findViewById(R.id.img_item_photo)
        tvitemname = findViewById(R.id.tv_item_name)
        tvitemlongdescription = findViewById(R.id.tv_item_longdescription)
        //list.addAll(getListUniversitas())

    }


    /*private fun getListUniversitas(): ArrayList<University> {
        val dataName = resources.getStringArray(R.array.data_name)
        val datalongDescription = resources.getStringArray(R.array.data_longdescription)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listUniversitas = ArrayList<University>()
        for (i in dataName.indices) {
            val universitas = University (dataName[i], datalongDescription[i],
                dataPhoto.getResourceId(i, -1)
            )
            listUniversitas.add(universitas)
        }
        return listUniversitas

    }*/
}