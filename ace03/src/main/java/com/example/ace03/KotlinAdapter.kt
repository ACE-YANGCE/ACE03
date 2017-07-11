package com.example.ace03

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by ACE on 2017/7/5 0005.
 */
class KotlinAdapter(val list: ArrayList<HomeLeftBean>, val context: Context) : BaseAdapter() {
    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: KotlinItemHolder
        var view: View
        if (convertView == null) {
            view = View.inflate(context, R.layout.recycle_view_item, null)
            holder = KotlinItemHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as KotlinItemHolder
        }
        holder.leftimg.setImageDrawable(context.resources.getDrawable(list[position].leftIcon))
        holder.middletv.text = list[position].leftName
        holder.rightimg.setImageDrawable(context.resources.getDrawable(R.mipmap.backback))
        return view
    }

}

class KotlinItemHolder(var viewItem: View) {
    var middletv: TextView = viewItem.findViewById(R.id.item_middle_tv) as TextView
    var leftimg: ImageView = viewItem.findViewById(R.id.item_left_iv) as ImageView
    var rightimg: ImageView = viewItem.findViewById(R.id.item_right_iv) as ImageView
}