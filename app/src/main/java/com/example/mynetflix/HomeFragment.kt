package com.example.mynetflix

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.mynetflix.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController

object Favorite{
    val numberOfFavoriteFilm : ArrayList<Int> = arrayListOf()
    val titleOfFilm : ArrayList<String> = arrayListOf("فیلم 1","فیلم 2","فیلم 3","فیلم 4","فیلم 5",
    "فیلم 6","فیلم 7","فیلم 8","فیلم 9","فیلم 10","فیلم 11","فیلم 12")
}

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    fun setListener(){
        val btnArray = arrayListOf(binding.button1, binding.button2, binding.button3,binding.button4,
            binding.button5,binding.button6,binding.button7,binding.button8,binding.button9,binding.button10,
            binding.button11,binding.button12)
        var count = 0
        for (number in Favorite.numberOfFavoriteFilm) {
            for (conut in 0 until btnArray.size) {
                if (count == number){
                    btnArray[count].setIconTintResource(R.color.red)
                }
            }
        }

        for (count in 0 until btnArray.size){
            btnArray[count].setOnClickListener {
                if(!Favorite.numberOfFavoriteFilm.contains(count) && Favorite.numberOfFavoriteFilm.size<6){
                    btnArray[count].setIconTintResource(R.color.red)
                    Favorite.numberOfFavoriteFilm.add(count)
                }
            }
        }
        binding.button1.setOnClickListener {
            //var title = binding.textView1.text.toString()
            //if(!Favorite.numberOfFilm.contains(title) && Favorite.numberOfFilm.size<6){
            //binding.button1.setIconTintResource(R.color.red)
            //Favorite.numberOfFilm.add(title)

            //var pic = R.drawable.poster
            //val bundle = bundleOf("title" to title, "poster" to pic)
            //findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment, bundle)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile -> {
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment2)
                true
            }
            R.id.favorite -> {
                findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                true
            }
            R.id.home -> {
                true
            }
            R.id.comingSoon -> {
                findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}