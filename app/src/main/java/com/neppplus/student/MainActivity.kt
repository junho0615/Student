package com.neppplus.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.student.adapters.StudentAdapter
import com.neppplus.student.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", 1988, "서울시 은평구"))
        mStudentList.add(Student("홍준호", 1995, "서울시 중구"))
        mStudentList.add(Student("김민철", 1990, "서울시 서대문구"))
        mStudentList.add(Student("김종진", 1991, "서울시 용산구"))
        mStudentList.add(Student("장혜진", 1993, "서울시 강동구"))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        studentListView.adapter = mAdapter

        studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

    }
}