import scala.util.{Success, Try}

val stringStringMap = Map[String, String]("key" -> "value")

val existingEntry = stringStringMap.get("key")
val nonExistingEntry = stringStringMap.get("bad_key")

val appended = existingEntry.map {
  s => s + " appended"
}

appended match {
  case Some(s: String) => s
  case None => "nothing in there"
}

val myTry = Try {
  appended.get
}.map {
  s: String => s + " more appending"
}

val myTryAgain = (s:Option[String]) => {
  Try(s.get) map {
    _ + " better thing to append"
  }
}

val list = "key" :: "bad_key" :: Nil

list map {
  stringStringMap.get(_)
} map {
  myTryAgain
} collect {
  case Success(s:String) => s
}
