package com.yazid.islami.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.yazid.islami.R
import com.yazid.islami.viewModelPackage.ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [sebha_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class sebha_fragment : Fragment() {

    private val ViewmodelInst: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_sebha_fragment, container, false)
        val IncBtm = view.findViewById<ImageView>(R.id.imageViewRadio)
        val ViewTxt = view.findViewById<TextView>(R.id.textView4)


        IncBtm.setOnClickListener {
            val rotateAnimator = ObjectAnimator.ofFloat(IncBtm,"rotation",0f,360f)
            rotateAnimator.duration = 1000
            rotateAnimator.start()
            ViewmodelInst.IncreaseCount()

        }
        ViewTxt.setOnClickListener{
            ViewmodelInst.reset()
        }
        ViewmodelInst.mutableLiveDataInt.observe(viewLifecycleOwner, Observer { value ->
            // Handle the updated value here
            // 'value' is the new value emitted by the LiveData
           ViewTxt.text= value.toString()
        })


        // Inflate the layout for this fragment
        return view
    }


}