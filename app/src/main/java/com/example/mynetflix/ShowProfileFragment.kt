package com.example.mynetflix

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mynetflix.databinding.FragmentProfileBinding
import com.example.mynetflix.databinding.FragmentShowProfileBinding

const val NAME = "NAME"
const val PHONE = "PHONE"
const val BORNDATE = "BORNDATE"
const val GENDER = "GENDER"
const val EMAIL = "EMAIL"
const val USERNAME = "USERNAME"

class ShowProfileFragment : Fragment() {

    lateinit var binding : FragmentShowProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInfo()
    }

    fun setInfo(){
        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE)
        binding.textViewName.text = "نام و نام خانوادگی: " + prefs.getString(NAME,"")
        binding.textViewUserName.text = "نام کاربری: " + prefs.getString(USERNAME,"")
        binding.textViewEmail.text = "ایمیل: " + prefs.getString(EMAIL,"")
        binding.textViewPhone.text = "تلفن: " + prefs.getString(PHONE,"")
        binding.textViewBornDate.text = "تاریخ تولد: " + prefs.getString(BORNDATE,"")
    }

//    fun goBackForEdit(){
//        val result= Intent()
//        result.putExtra(EDIT,true)
//        setResult(AppCompatActivity.RESULT_OK,result)
//        finish()
//    }
//
//    fun goBackForEnterNewUser(){
//        val result= Intent()
//        result.putExtra(NEWUSER, true)
//        setResult(AppCompatActivity.RESULT_OK,result)
//        finish()
//    }

}