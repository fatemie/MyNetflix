package com.example.mynetflix

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.mynetflix.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController

object Favorite{
    val arrayTitle : ArrayList<String> = arrayListOf()
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
        binding.button1.setOnClickListener {
            var title = binding.textView1.text.toString()
            var pic = R.drawable.poster
            if(Favorite.arrayTitle.size<6){
                Favorite.arrayTitle.add(title)
            }
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