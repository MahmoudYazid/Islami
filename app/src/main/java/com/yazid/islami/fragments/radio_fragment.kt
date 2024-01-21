package com.yazid.islami.fragments

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.lifecycleScope
import com.yazid.islami.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [radio_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class radio_fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_radio_fragment, container, false)
        // Inflate the layout for this fragment
        val playBtm = view.findViewById<ImageView>(R.id.play)
        val forwardBtm = view.findViewById<ImageView>(R.id.forward)
        val backwordBtm = view.findViewById<ImageView>(R.id.backword)
        val webView: WebView =  view.findViewById(R.id.webView)
        var Channel = mutableListOf<String>()
        Channel.add("https://backup.qurango.net/radio/ibrahim_alakdar")
        Channel.add("https://backup.qurango.net/radio/ahmad_alajmy")
        Channel.add("https://backup.qurango.net/radio/ahmad_saber")
        var ChannelNumber=0
        var signal = false

        playBtm.setOnClickListener{
                    if (!signal){
                        PlayAudio(webView,Channel[ChannelNumber])
                        Toast.makeText(requireContext(),"start",Toast.LENGTH_LONG).show()
                        signal=true
                    }else{
                        StopAudio(webView)
                        Toast.makeText(requireContext(),"stop",Toast.LENGTH_LONG).show()
                        signal=false
                    }
        }

        forwardBtm.setOnClickListener{
            if (ChannelNumber>=2){
                ChannelNumber=0
            }else{
                ChannelNumber++
            }

            PlayAudio(webView,Channel[ChannelNumber])
            Toast.makeText(requireContext(),"start",Toast.LENGTH_LONG).show()
            signal=true
        }

        backwordBtm.setOnClickListener{
            if (ChannelNumber<=0){
                ChannelNumber=0
            }else{
                ChannelNumber--
            }

            PlayAudio(webView,Channel[ChannelNumber])
            Toast.makeText(requireContext(),"start",Toast.LENGTH_LONG).show()
            signal=true
        }
        return view


    }



// ...

    fun PlayAudio(webView:WebView,ChannelUrl:String) {
        // Replace "https://backup.qurango.net/radio/ibrahim_alakdar" with your actual audio URL




        // Enable JavaScript (optional, depending on your needs)
        webView.settings.javaScriptEnabled = true


        // Set a WebViewClient to handle page navigation
        webView.webViewClient = WebViewClient()
        // Load the URL into the WebView
        webView.loadUrl(ChannelUrl)


        }

    fun StopAudio(webView:WebView) {
        // Replace "https://backup.qurango.net/radio/ibrahim_alakdar" with your actual audio URL




        // Enable JavaScript (optional, depending on your needs)
        webView.settings.javaScriptEnabled = true


        // Set a WebViewClient to handle page navigation
        webView.webViewClient = WebViewClient()
        // Load the URL into the WebView
        webView.loadUrl("google.com")


    }

}