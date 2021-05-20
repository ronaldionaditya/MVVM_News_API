package com.mobile.mvvmnewsapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobile.mvvmnewsapi.R
import com.mobile.mvvmnewsapi.adapter.NewsAdapter
import com.mobile.mvvmnewsapi.model.ResponseServer
import com.mobile.mvvmnewsapi.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var view : ViewModelActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = ViewModelProviders.of(this).get(ViewModelActivity::class.java)

        attachObserve()

        view.Panggil()

    }

    private fun attachObserve() {
        view.success().observe(this, Observer { showSuccess(it) })
        view.error().observe(this, Observer { showError(it) })
    }

    private fun showError(it: Throwable?) {
        Toast.makeText(applicationContext, "Salah", Toast.LENGTH_LONG).show()
    }


    private fun showSuccess(data: ResponseServer) {
        Toast.makeText(applicationContext, "tt", Toast.LENGTH_LONG).show()
        var adapter = NewsAdapter(data.articles)
        listNews.adapter = adapter
    }
}