package com.vipulasri.jetinstagram.model

data class Post(
  val id: Int,
  val image: String,
  val user: User,
  val isLiked: Boolean = false,
  val likesCount: Int,
  val commentsCount: Int,
  val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val isSeen: Boolean = false
)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)
val fullNames = arrayOf(
    "Stella O'Reilly",
    "Nia Nicholson",
    "Owen Piers Inglewood",
    "Asher O'Keefe",
    "Darren K. Emeralds",
    "Benjamin Edgar D'Tan",
    "Shrishankar Mittal",
    "Matthew Donoghue",
    "Phillip Sohnberg",
    "Damien Eitchison"
)