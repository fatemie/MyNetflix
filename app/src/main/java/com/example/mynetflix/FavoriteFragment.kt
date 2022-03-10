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

        val txtViewArray = arrayListOf(binding.textView1,binding.textView2,binding.textView3
                                        ,binding.textView4, binding.textView5)
        val imgViewArray = arrayListOf(binding.imageView1,binding.imageView2,binding.imageView3
                                    ,binding.imageView4,binding.imageView5)
        var count = 0
        for(number in Favorite.numberOfFavoriteFilm){
            txtViewArray[count].text = Favorite.titleOfFilm[number]
            imgViewArray[count].setImageResource(R.drawable.poster)
            count++
        }

    }

}