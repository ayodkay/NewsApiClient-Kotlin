package com.example.newsapikotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.client.NewsApiClient
import com.github.ayodkay.init.NewsApi
import com.github.ayodkay.interfaces.ArticlesResponseCallback
import com.github.ayodkay.interfaces.SourcesCallback
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.SourcesResponse

val TAG = MainActivity::class.simpleName
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NewsApi.init(this)
        val newsApiClient = NewsApiClient("YOUR_API_KEY")

//        val newsApiClient = NewsApiClient("YOUR_API_KEY",
//            NetworkInterceptorModel(), OfflineCacheInterceptorModel())

//        val newsApiClient = NewsApiClient("YOUR_API_KEY", NetworkInterceptorModel())

//        val newsApiClient = NewsApiClient("YOUR_API_KEY", OfflineCacheInterceptorModel())

        //everything https://newsapi.org/docs/endpoints/everything
        val everythingBuilder = EverythingBuilder.Builder()
            .q("bitcoin")
            .build()

        newsApiClient.getEverything(
            everythingBuilder,
            object : ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse) {
                    Log.d(TAG, "onSuccess articles: ${response.articles}")
                    Log.d(TAG, "onSuccess status: ${response.status}")
                    Log.d(TAG, "onSuccess totalResults: ${response.totalResults}")
                    Log.d(TAG, "-------------------------------------------------")
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            }
        )

        //top-headlines https://newsapi.org/docs/endpoints/top-headlines
        val topHeadlinesBuilder = TopHeadlinesBuilder.Builder()
            .q("bitcoin")
            .build()

        newsApiClient.getTopHeadlines(
            topHeadlinesBuilder,
            object : ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse) {
                    Log.d(TAG, "onSuccess articles: ${response.articles}")
                    Log.d(TAG, "onSuccess status: ${response.status}")
                    Log.d(TAG, "onSuccess totalResults: ${response.totalResults}")
                    Log.d(TAG, "-------------------------------------------------")
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            }
        )


        //sources https://newsapi.org/docs/endpoints/sources
        val sourcesBuilder = SourcesBuilder.Builder()
            .language("en")
            .country("us")
            .build()

        newsApiClient.getSources(
            sourcesBuilder,
            object : SourcesCallback {
                override fun onSuccess(response: SourcesResponse) {
                    Log.d(TAG, "onSuccess articles: ${response.sources}")
                    Log.d(TAG, "onSuccess status: ${response.status}")
                    Log.d(TAG, "-------------------------------------------------")
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            }
        )
    }
}