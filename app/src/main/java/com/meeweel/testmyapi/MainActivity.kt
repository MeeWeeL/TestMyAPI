package com.meeweel.testmyapi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.core.text.htmlEncode
import com.meeweel.testmyapi.api.AnimeApi
import com.meeweel.testmyapi.api.AnimeApp
import com.meeweel.testmyapi.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {


    lateinit var image: Bitmap
    lateinit var anime: Anime
    private val compositeDisposable = CompositeDisposable()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun fetchAnimeList(animeApi: AnimeApi, num: Int) {
        val a = when (num) {
            1 -> animeApi.getAnime1()
            2 -> animeApi.getAnime2()
            else -> animeApi.getAnime1()
        }

        compositeDisposable.add(a
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                doTo("Done!")
                anime = Anime(it.title,it.description,it.image)
                binding.title.text = anime.title
                binding.description.text = anime.description
                loadPicture()
            }, {
                doTo("Fail!!!")
            }))
    }

    private fun doTo(x: String) {
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show()
    }
    fun go1(view: android.view.View) {
        fetchAnimeList((application as AnimeApp).animeApi, 1)
    }

    fun go2(view: android.view.View) {
        fetchAnimeList((application as AnimeApp).animeApi, 2)
    }

    fun loadPicture() {
        Thread {
            try {
                val url = URL(anime.image)
                image = BitmapFactory.decodeStream(url.openStream())
            } catch (e: IOException) {
            }
            runOnUiThread {
                binding.image.setImageBitmap(image)
            }
        }.start()
    }
}