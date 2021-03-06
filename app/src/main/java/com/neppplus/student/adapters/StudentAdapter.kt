package com.neppplus.student.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.student.R
import com.neppplus.student.datas.Student
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

        val studentData = mList[position]

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)

        nameTxt.text = studentData.name
//        ageTxt.text = "(${studentData.birthYear}세)"


        ageTxt.text = "(${studentData.getKoreanAge()}세)"

        addressTxt.text = studentData.address

        return row

    }
}