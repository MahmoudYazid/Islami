package com.yazid.islami.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.yazid.islami.R
import com.yazid.islami.model.HadeethApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ahadeth_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ahadeth_fragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_ahadeth_fragment, container, false)

        val HadeethText = view.findViewById<TextView>(R.id.textView4)
        HadeethText.setMovementMethod(ScrollingMovementMethod())
        var hadeeth =""
        viewLifecycleOwner.lifecycleScope.launch {
            launch(Dispatchers.IO){
                var IdGenerated = Random.nextInt(2940, 2960).toString()
                hadeeth = retrofitService.getHadeth(id =IdGenerated ).hadeeth.toString()
                HadeethText.text=hadeeth
            }

        }

        // Inflate the layout for this fragment
        return view
    }




}