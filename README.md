# NewsApiClient-Kotlin

[![](https://jitpack.io/v/ayodkay/NewsApiClient-Kotlin.svg)](https://jitpack.io/#ayodkay/NewsApiClient-Kotlin)

**Create an account at [newsapi.org](https://newsapi.org/) to get your API key.**

#### Step 1. Add the JitPack repository to your root ```build.gradle``` file.

``` kotlin
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

#### Step 2 : Download via ```Gradle```:

```kotlin
implementation 'com.github.ayodkay:NewsApiClient-Kotlin:1.0.0'
```


## Usage

#### Instantiate the Client class:

``` java 
val newsApiClient = NewsApiClient("YOUR_API_KEY")
```

``` java 
val newsApiClient = NewsApiClient("YOUR_API_KEY", NetworkInterceptorModel(), OfflineCacheInterceptorModel())
```

``` java 
val newsApiClient = NewsApiClient("YOUR_API_KEY", NetworkInterceptorModel())
```

``` java 
val newsApiClient = NewsApiClient("YOUR_API_KEY", OfflineCacheInterceptorModel())
```

**```NetworkInterceptorModel()``` and ```OfflineCacheInterceptorModel()``` helps cache result for a specific amount of hours, minutes or even days. By default it is 1 hour and to change**

``` java 
val newsApiClient = NewsApiClient("YOUR_API_KEY", NetworkInterceptorModel(1,TimeUnit.MINUTES))
```

``` java 
val newsApiClient = NewsApiClient("YOUR_API_KEY", OfflineCacheInterceptorModel(1,TimeUnit.DAYS))
```

#### Get Top EveryThing [doc](https://newsapi.org/docs/endpoints/everything)
```kotlin
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
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            }
        )
```

#### Get Top Headlines [doc](https://newsapi.org/docs/endpoints/top-headlines)

```kotlin
val topHeadlinesBuilder = TopHeadlinesBuilder.Builder()
            .q("bitcoin")
            .language("en")
            .build()

        newsApiClient.getTopHeadlines(
            topHeadlinesBuilder,
            object : ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse) {
                    Log.d(TAG, "onSuccess articles: ${response.articles}")
                    Log.d(TAG, "onSuccess status: ${response.status}")
                    Log.d(TAG, "onSuccess totalResults: ${response.totalResults}")
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            }
        )
```

#### Get Sources [doc](https://newsapi.org/docs/endpoints/sources)
```kotlin
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
                }

                override fun onFailure(throwable: Throwable) {
                    Log.d(TAG, "onFailure: $throwable")
                }

            }
        )
```





