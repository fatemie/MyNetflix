package com.example.mynetflix

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.mynetflix.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding
    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = requireActivity().getSharedPreferences(resources.getString(R.string.app_name),
            AppCompatActivity.MODE_PRIVATE)
            checkSharedPreferenceEmpty()
            setListener()
    }

    fun checkSharedPreferenceEmpty(){
        val name = prefs.getString(NAME,"")
        if(!name.isNullOrEmpty()){

            findNavController().navigate(R.id.action_profileFragment2_to_showProfileFragment)
        }
    }

    private fun setListener() {
        binding.buttonRegister.setOnClickListener {
            if(checkAllFieldComplete()){
                seveInfo()
                findNavController().navigate(R.id.action_profileFragment2_to_showProfileFragment)
            }
        }
    }

    private fun checkAllFieldComplete() :Boolean{

        checkFieldComplete(binding.editTextPersonName)
        checkFieldComplete(binding.editTextUserName)
        checkFieldComplete(binding.editTextEmail)
        checkFieldComplete(binding.editTextBornDate)
        checkFieldComplete(binding.editTextPhone)

        if(checkFieldComplete(binding.editTextPersonName) &&
            checkFieldComplete(binding.editTextUserName) &&
            checkFieldComplete(binding.editTextEmail) &&
            checkFieldComplete(binding.editTextBornDate) &&
            checkFieldComplete(binding.editTextPhone)){
            return true
        }
        return false
    }

    fun checkFieldComplete(editText: EditText): Boolean{
        if(editText.text.length == 0){
            editText.setError("لطفا این قسمت را تکمیل کنید")
            return false
        }
        return true
    }

    private fun seveInfo() {
        val editor =  prefs.edit()
        editor.putString(NAME, binding.editTextPersonName.text.toString())
        editor.putString(USERNAME, binding.editTextUserName.text.toString())
        editor.putString(EMAIL, binding.editTextEmail.text.toString())
        editor.putString(BORNDATE, binding.editTextBornDate.text.toString())
        editor.putString(PHONE, binding.editTextPhone.text.toString())
        editor.apply()
    }



}