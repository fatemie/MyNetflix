package com.example.mynetflix

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.mynetflix.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController
import android.view.MenuInflater

object Favorite{
    val numberOfFavoriteFilm : ArrayList<Int> = arrayListOf()
    val titleOfFilm : ArrayList<String> = arrayListOf("علفزار","موقعیت مهدی","بدون قرار قبلی","درخت گردو","نگهبان شب",
    "شب طلایی","فیلم 7","فیلم 8","فیلم 9","فیلم 10","فیلم 11","فیلم 12")
    var isSigneIn = false
}

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val btnArray = arrayListOf(binding.button1, binding.button2, binding.button3,binding.button4,
        binding.button5,binding.button6,binding.button7,binding.button8,binding.button9,binding.button10,
        binding.button11,binding.button12)

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
        initViews()
        setListener()
    }

    fun initViews(){


        for (number in Favorite.numberOfFavoriteFilm) {
            for (countbtn in 0 until btnArray.size) {
                if (countbtn == number){
                    btnArray[countbtn].setIconTintResource(R.color.red)
                }
            }
        }
    }

    fun setListener(){
        for (count in 0 until btnArray.size){
            btnArray[count].setOnClickListener {
                if(!Favorite.numberOfFavoriteFilm.contains(count) && Favorite.numberOfFavoriteFilm.size<6) {
                    if(Favorite.isSigneIn) {
                        btnArray[count].setIconTintResource(R.color.red)
                        Favorite.numberOfFavoriteFilm.add(count)
                    }else{
                        Toast.makeText(activity, "لطفا ابتدا اطلاعات خود را وارد کنید", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
//        binding.button1.setOnClickListener {
//            //var title = binding.textView1.text.toString()
//            //if(!Favorite.numberOfFilm.contains(title) && Favorite.numberOfFilm.size<6){
//            //binding.button1.setIconTintResource(R.color.red)
//            //Favorite.numberOfFilm.add(title)
//
//            //var pic = R.drawable.poster
//            //val bundle = bundleOf("title" to title, "poster" to pic)
//            //findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment, bundle)
//        }
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
            R.id.comingSoon -> {
                findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu,inflater)
    }

}