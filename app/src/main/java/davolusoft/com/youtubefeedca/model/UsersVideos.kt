package davolusoft.com.youtubefeedca.model

import java.io.Serializable

data class UsersVideos (val user: User, val videos: List<YoutubeVideos>): Serializable
