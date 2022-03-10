package com.example.mynetflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mynetflix.databinding.FragmentComingSoonBinding
import com.example.mynetflix.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    lateinit var binding : FragmentFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  var title = requireArguments().getString("title")
       // var pic = requireArguments().getInt("poster")
        for(title in Favorite.arrayTitle){
            if(title != ""){
                binding.textView1.text = title
                binding.imageView1.setImageResource(R.drawable.poster)
            }
        }
       // binding.imageView1.setImageResource(pic)


    }

}