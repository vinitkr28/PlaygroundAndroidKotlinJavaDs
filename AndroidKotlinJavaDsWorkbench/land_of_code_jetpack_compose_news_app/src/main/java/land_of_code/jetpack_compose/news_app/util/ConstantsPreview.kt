package land_of_code.jetpack_compose.news_app.util

import land_of_code.jetpack_compose.news_app.domain.model.Article
import land_of_code.jetpack_compose.news_app.domain.model.Source

object ConstantsPreview {

    val articlePreviewInputType1 = Article(
        author = "NYT News Service",
        content = "One Saturday evening in late July, more than 100 people attended an elaborate party in the lush garden of a mansion in Silicon Valley. The host was David Wei, a former CEO of Alibaba, the Chinese e-c… [+6800 chars]",
        description = "With China's economy in a lasting slump, investors and entrepreneurs are seeking the next China. They feel unwelcome by their government, which in recent years has sent an ominous message by clamping down on private companies. The heightened tensions between …",
        publishedAt = "2024-09-07T13:28:01Z",
        source = Source(id = "the-times-of-india", name = "The Times of India"),
        title = "Chinese tech investors struggle for a toehold in Silicon Valley",
        url = "https://economictimes.indiatimes.com/tech/technology/chinese-tech-investors-struggle-for-a-toehold-in-silicon-valley/articleshow/113153221.cms",
        urlToImage = "https://img.etimg.com/thumb/msid-113153226,width-1200,height-630,imgsize-129990,overlay-ettech/photo.jpg"
    )
}