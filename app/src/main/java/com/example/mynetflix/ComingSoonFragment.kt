package com.example.mynetflix

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.mynetflix.databinding.FragmentComingSoonBinding
import com.example.mynetflix.databinding.FragmentHomeBinding

class ComingSoonFragment : Fragment() {

    lateinit var binding : FragmentComingSoonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComingSoonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setIconTintResource(R.color.black)
        binding.button2.setIconTintResource(R.color.black)
        binding.button3.setIconTintResource(R.color.black)

        binding.button1.setOnClickListener {
            if (Favorite.isSigneIn) {
                share("film1")
            }else{
                Toast.makeText(activity, "لطفا ابتدا اطلاعات خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
        }

        binding.button2.setOnClickListener {
            if (Favorite.isSigneIn) {
                share("film2")
            }else{
                Toast.makeText(activity, "لطفا ابتدا اطلاعات خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
        }

        binding.button3.setOnClickListener {
            if (Favorite.isSigneIn) {
                share("film3")
            }else{
                Toast.makeText(activity, "لطفا ابتدا اطلاعات خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setListener(){
        val btnArray :ArrayList <Button> = arrayListOf(binding.button1,binding.button2,binding.button3)
        for(btn in btnArray){
            btn.setOnClickListener {
            }
        }

    }
    fun share(str : String){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, str)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}