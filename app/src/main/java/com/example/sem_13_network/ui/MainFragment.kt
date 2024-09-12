package com.example.sem_13_network.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.sem_13_network.R


class MainFragment : Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = requireActivity().findViewById<ImageView>(R.id.img_cat)

        lifecycleScope.launchWhenStarted {
            val response = RetrofitServices.searchImageApiC.getCatImageList()
            imageView.load(response.body()?.first()?.url)
        }

        //using main thread
        /*thread {
        val response = RetrofitInstance.searchImageApiC.getCatImageList().execute()
        imageView.load(response.body()?.first()?.url)
        }*/


        /*val textView = requireActivity().findViewById<TextView>(R.id.text)
        val jsonCat = """{
            "id":12,
            "url":"FromJson"
            }""".trimIndent()*/

        // Realization using Gson lib

        /*val catImageAdapter = Gson().getAdapter(CatImageModel::class.java)
        val catImageModel: CatImageModel = catImageAdapter.fromJson(jsonCat)
        val deserializedString = catImageAdapter.toJson(catImageModel)
        textView.text = catImageModel.toString()
        textView.text = deserializedString*/

        // Realization using Gson lib

        /*val catImageAdapter = Moshi.Builder().build().adapter(CatImageModel::class.java)
        val catImageModel: CatImageModel = catImageAdapter.fromJson(jsonCat) ?: error("Unable to convert")
        val deserializedJson = catImageAdapter.toJson(catImageModel)
        textView.text = catImageModel.toString()
        textView.text = deserializedJson*/
    }


}