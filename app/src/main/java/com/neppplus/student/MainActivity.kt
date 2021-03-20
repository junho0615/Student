package com.neppplus.student

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제")
            alert.setMessage("정말 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                mStudentList.removeAt(position)
                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)

            alert.show()


            return@setOnItemLongClickListener true
        }

    }
}