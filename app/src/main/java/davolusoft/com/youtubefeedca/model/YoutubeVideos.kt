package davolusoft.com.youtubefeedca.model

import java.io.Serializable


data class YoutubeVideos (val id: Int, val name: String, val imageUrl: String, val numberOfViews: Int, val channel: Channel): Serializable
