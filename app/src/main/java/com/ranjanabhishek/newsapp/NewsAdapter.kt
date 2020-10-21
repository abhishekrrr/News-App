package com.ranjanabhishek.newsapp

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.getSystemService

class NewsAdapter(context: Context, arrayList: ArrayList<Data>):BaseAdapter() {


    var arrayList: ArrayList<Data> = ArrayList()
    var context: Context?

    init {
        this.context = context
        this.arrayList = arrayList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder
        val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if(convertView == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.news_item,parent, false)
            holder.sectionName = view.findViewById(R.id.section_name_text_view)
            holder.webTitle = view.findViewById(R.id.news_title)
            view.tag = holder
        }
        else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val sectionNameValue = holder.sectionName
        sectionNameValue?.text = arrayList[position].sectionName

        val textValue=holder.webTitle
        textValue?.text = arrayList[position].webTitile
        return view
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    class ViewHolder{
        var sectionName : TextView? =null
        var webTitle: TextView? = null


    }

}