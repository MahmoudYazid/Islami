package com.yazid.islami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yazid.islami.R
import com.yazid.islami.adaptors.Ayahadaptor
import com.yazid.islami.model.DataItem
import com.yazid.islami.model.HadeethApi
import com.yazid.islami.model.ISurahWebOpen
import com.yazid.islami.model.SurahApi
import com.yazid.islami.model.SurahResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Objects
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [quran_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class quran_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_quran_fragment, container, false)
        val webView: WebView =  view.findViewById(R.id.WebViewForQouran)
        val FloatActionInst: FloatingActionButton =  view.findViewById(R.id.floatingActionButton)
        //Interface Callback
        FloatActionInst.hide()

        val recyclerViewAyah = view.findViewById<RecyclerView>(R.id.ayah_recyclerViewId)


        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val surahArray = withContext(Dispatchers.IO) {
                    SurahApi.retrofitService.getAllSurah().data
                }

                val Adaptor = Ayahadaptor(surahArray)
                recyclerViewAyah.adapter = Adaptor
                Adaptor.ISurahWebOpenInst = object :ISurahWebOpen{
                    override fun OpenSurahNumber(Id: String) {

                            webView.settings.javaScriptEnabled = true


                            // Set a WebViewClient to handle page navigation
                            webView.webViewClient = WebViewClient()

                            if (Id.toInt()<10){
                                Toast.makeText(requireContext(), "00$Id", Toast.LENGTH_SHORT).show()

                                webView.loadUrl("https://server6.mp3quran.net/akdr/00$Id.mp3")
                            }
                            if (Id.toInt()>=10 && Id.toInt()<100){
                                Toast.makeText(requireContext(), "0$Id", Toast.LENGTH_SHORT).show()

                                webView.loadUrl("https://server6.mp3quran.net/akdr/0$Id.mp3")
                            }
                            if (Id.toInt()>=100){
                                Toast.makeText(requireContext(), "$Id", Toast.LENGTH_SHORT).show()

                                webView.loadUrl("https://server6.mp3quran.net/akdr/$Id.mp3")
                            }

                            FloatActionInst.show()
                            // Load the URL into the WebView

                        }
                    }



            } catch (e: Exception) {
                // Handle exceptions (e.g., network errors)
                Toast.makeText(requireContext(), "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        }


        FloatActionInst.setOnClickListener{

            webView.settings.javaScriptEnabled = true


            // Set a WebViewClient to handle page navigation
            webView.webViewClient = WebViewClient()
            webView.loadUrl("https://google.com")
            FloatActionInst.hide()

        }


        return view
    }


}