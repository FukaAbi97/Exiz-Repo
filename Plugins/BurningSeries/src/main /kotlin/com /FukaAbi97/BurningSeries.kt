package com.FukaAbi97

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.extractors.StreamTape
import org.jsoup.Jsoup

class BurningSeries : MainAPI() {
    override var name = "BurningSeries"
    override var mainUrl = "https://www.burningseries.io"
    override var lang = "de"
    override val supportedTypes = setOf(TvType.TvSeries)

    override suspend fun search(query: String): List<SearchResponse> {
        val doc = Jsoup.connect("$mainUrl/search/$query").get()
        return doc.select(".series").map {
            val title = it.text()
            val url = it.attr("href")
            TvSeriesSearchResponse(title, "$mainUrl$url", this.name)
        }
    }

    override suspend fun load(url: String): LoadResponse? {
        val doc = Jsoup.connect(url).get()
        val title = doc.select("h1").text()
        val episodes = doc.select(".episode").map {
            val epTitle = it.text()
            val epUrl = it.attr("href")
            Episode(epUrl, epTitle)
        }
        return TvSeriesLoadResponse(title, url, this.name, episodes)
    }

    override suspend fun loadLinks(data: String): List<Video> {
        val doc = Jsoup.connect(data).get()
        return doc.select("a[href*='streamcloud']").map {
            val streamUrl = it.attr("href")
            Video(streamUrl, "Streamcloud", streamUrl)
        }
    }
}
