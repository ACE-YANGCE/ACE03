package com.example.ace03

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycle_view_header.*
import java.util.*

class MainActivityK : AppCompatActivity() {

    var mDataList = ArrayList<HomeLeftBean>()
    var myAdapter: KotlinAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        myAdapter = KotlinAdapter(mDataList, this)
        wave_lv.adapter = myAdapter
        val view = LayoutInflater.from(this).inflate(
                R.layout.recycle_view_header, null)
        wave_lv.addHeaderView(view, null, false)
        val fview = LayoutInflater.from(this).inflate(
                R.layout.recycle_view_footer, null)
        wave_lv.addFooterView(fview, null, false)
        view?.setOnClickListener {
            Toast.makeText(this, "这是标题栏目!", Toast.LENGTH_LONG).show()
        }
        header_tv?.setOnClickListener {
            Toast.makeText(this, "这是标题哦!", Toast.LENGTH_LONG).show()
        }
        wave_lv?.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, mDataList[position - 1].leftName, Toast.LENGTH_LONG).show()
        }
    }

    fun initData() {
        for (i in 1..10) {
            var bean: HomeLeftBean? = HomeLeftBean()
            bean!!.leftName = "数据" + i
            bean!!.leftIcon = R.mipmap.ic_bottom_music
            mDataList.add(bean)
        }
    }
}
