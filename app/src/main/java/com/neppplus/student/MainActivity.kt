package com.neppplus.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.student.adapters.StudentAdapter
import com.neppplus.student.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("홍준호", 1995))
        mStudentList.add(Student("김민철", 1990))
        mStudentList.add(Student("김종진", 1991))
        mStudentList.add(Student("장혜진", 1993))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)


    }
}