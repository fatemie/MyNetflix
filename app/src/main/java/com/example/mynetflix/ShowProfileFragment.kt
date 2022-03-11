package com.example.mynetflix

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mynetflix.databinding.FragmentProfileBinding
import com.example.mynetflix.databinding.FragmentShowProfileBinding
import kotlin.math.E

const val NAME = "NAME"
const val PHONE = "PHONE"
const val BORNDATE = "BORNDATE"
const val GENDER = "GENDER"
const val EMAIL = "EMAIL"
const val USERNAME = "USERNAME"
const val isSigneIn = "isSigneIn"

class ShowProfileFragment : Fragment() {

    lateinit var binding : FragmentShowProfileBinding
    lateinit var prefs : SharedPreferences
    lateinit var name : String
    lateinit var username : String
    lateinit var email : String
    lateinit var borndate : String
    lateinit var phone : String

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
        prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE)
        setInfo()
        binding.buttonEdit.setOnClickListener {
            saveInfo()
        }
    }

    fun setInfo(){

        name = requireArguments().getString(NAME).toString()
        username = requireArguments().getString(USERNAME).toString()
        email = requireArguments().getString(EMAIL).toString()
        borndate = requireArguments().getString(BORNDATE).toString()
        phone = requireArguments().getString(PHONE).toString()

//        var prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
//            AppCompatActivity.MODE_PRIVATE)
        binding.textViewName.text = "نام و نام خانوادگی: " + name
        binding.textViewUserName.text = "نام کاربری: " + username
        binding.textViewEmail.text = "ایمیل: " + email
        binding.textViewPhone.text = "تلفن: " + phone
        binding.textViewBornDate.text = "تاریخ تولد: " + borndate
    }

    private fun saveInfo() {
        val editor =  prefs.edit()
        editor.putString(NAME, name)
        editor.putString(USERNAME, username)
        editor.putString(EMAIL, email)
        editor.putString(BORNDATE, borndate)
        editor.putString(PHONE, phone)
        //editor.putBoolean(isSigneIn, true)
        Favorite.isSigneIn = true
        editor.apply()
    }


}