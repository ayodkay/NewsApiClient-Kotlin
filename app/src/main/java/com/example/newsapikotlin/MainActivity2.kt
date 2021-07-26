package com.example.newsapikotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.constants.NewsConstant
import com.github.ayodkay.init.NewsApi
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.NetworkInterceptorModel
import com.github.ayodkay.models.OfflineCacheInterceptorModel
import com.github.ayodkay.models.SourcesResponse
import com.github.ayodkay.mvvm.client.NewsApiClientWithObserver
import com.github.ayodkay.mvvm.interfaces.ArticlesLiveDataResponseCallback
import com.github.ayodkay.mvvm.interfaces.SourcesLiveDataCallback

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        NewsApi.init(this)
        val newsApiClientWithObserver = NewsApiClientWithObserver(
            "YOUR_API_KEY",
            NetworkInterceptorModel(), OfflineCacheInterceptorModel()
        )


//        val newsApiClientWithObserver = NewsApiClientWithObserver("YOUR_API_KEY",
//            NetworkInterceptorModel(), OfflineCacheInterceptorModel())

//        val newsApiClientWithObserver =
//            NewsApiClientWithObserver("YOUR_API_KEY", NetworkInterceptorModel())

//        val newsApiClientWithObserver =
//            NewsApiClientWithObserver("YOUR_API_KEY", OfflineCacheInterceptorModel())

        //everything https://newsapi.org/docs/endpoints/everything
        val everythingBuilder = EverythingBuilder.Builder()
            .q("bitcoin")
            .build()
        newsApiClientWithObserver
            .getEverything(everythingBuilder, object : ArticlesLiveDataResponseCallback {
                override fun onSuccess(response: MutableLiveData<ArticleResponse>) {
                    response.observe(this@MainActivity2, {
                        Log.d(TAG, "onSuccess articles: ${it.articles}")
                        Log.d(TAG, "onSuccess status: ${it.status}")
                        Log.d(TAG, "onSuccess totalResults: ${it.totalResults}")
                        Log.d(TAG, "-------------------------------------------------")
                    })
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            })

        //top-headlines https://newsapi.org/docs/endpoints/top-headlines
        val topHeadlinesBuilder = TopHeadlinesBuilder.Builder()
            .q("bitcoin")
            .country(NewsConstant.COUNTRY_BR)
            .category(NewsConstant.CATEGORY_BUSINESS)
            .build()

        newsApiClientWithObserver
            .getTopHeadlines(topHeadlinesBuilder, object : ArticlesLiveDataResponseCallback {
                override fun onSuccess(response: MutableLiveData<ArticleResponse>) {
                    response.observe(this@MainActivity2, {
                        Log.d(TAG, "onSuccess articles topHeadlinesBuilder: ${it.articles}")
                        Log.d(TAG, "onSuccess status topHeadlinesBuilder: ${it.status}")
                        Log.d(TAG, "onSuccess totalResults topHeadlinesBuilder: ${it.totalResults}")
                        Log.d(TAG, "-------------------------------------------------")
                    })
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            })


        //sources https://newsapi.org/docs/endpoints/sources
        val sourcesBuilder = SourcesBuilder.Builder()
            .language("en")
            .country("us")
            .build()

        newsApiClientWithObserver
            .getSources(sourcesBuilder, object : SourcesLiveDataCallback {
                override fun onSuccess(response: MutableLiveData<SourcesResponse>) {
                    response.observe(this@MainActivity2, {
                        Log.d(TAG, "onSuccess status getSources: ${it.status}")
                        Log.d(TAG, "onSuccess status getSources: ${it.sources}")
                        Log.d(TAG, "-------------------------------------------------")
                    })
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            })
    }
}