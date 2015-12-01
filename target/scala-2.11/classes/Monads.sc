import scala.util.Try

val stringStringMap = Map[String,String]("key" -> "value")

val existingEntry = stringStringMap.get("key")
val nonExistingEntry = stringStringMap.get("bad_key")

val appended = existingEntry.map{
  s => s + " appended"
}

nonExistingEntry.get

appended match {
  case Some(s:String) => s
  case None => "nothing in there"
}

val myTry = Try{
  _ => appended.get
}
