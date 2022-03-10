package com.example.mynetflix

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
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
            //checkSharedPreferenceEmpty()
            setListener()
    }

//    fun checkSharedPreferenceEmpty(){
//        //val isSigned = prefs.getBoolean(isSigneIn,false)
//        if(Favorite.isSigneIn){
//            Favorite.isSigneIn = false
//            findNavController().navigate(R.id.action_profileFragment2_to_showProfileFragment)
//        }
//    }

    private fun setListener() {
        binding.buttonRegister.setOnClickListener {
            if(checkAllFieldComplete()){
                sendInfo()
//                findNavController().navigate(R.id.action_profileFragment2_to_showProfileFragment)
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
        //editor.putBoolean(isSigneIn, true)
        Favorite.isSigneIn = true
        editor.apply()
    }

    fun sendInfo(){
        val bundle = bundleOf(NAME to binding.editTextPersonName.text.toString(),
                                USERNAME to binding.editTextUserName.text.toString(),
                                EMAIL to binding.editTextEmail.text.toString(),
                                BORNDATE to binding.editTextBornDate.text.toString(),
                                PHONE to binding.editTextPhone.text.toString())
        findNavController().navigate(R.id.action_profileFragment2_to_showProfileFragment, bundle)
    }


}