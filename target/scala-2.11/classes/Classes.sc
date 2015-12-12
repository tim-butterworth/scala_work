var l = 7

val m = l + 8

class WithConstructor(val item:String,var count:Int) {

  private val constructed = item + count
  private val argMap = Map(item -> count, "default" -> 2)

  def this(item:String){
    this(item, 2)
  }
}

object WithConstructor {
  def apply() = new WithConstructor("default", -1)
  def unapply(obj:WithConstructor):Option[(String, Int)] ={
    Some(obj.item,obj.count)
  }
}

var matchable = WithConstructor()

matchable match {
  case WithConstructor(_, 4) => println("WOAHHH!")
  case WithConstructor("default",_) => println("The default I guess")
  case WithConstructor(item, count) => println(item + " " + count)
}

case class CaseClass(name:String, breeds:List[String])

val fidoTurtle = CaseClass("fido",  "turtle" :: "t-rex" :: Nil)

sealed trait TimeOfDay{
  def startHour:Int
}

case class Morning() extends TimeOfDay {
  def startHour = 6
}
case class Afternoon(startHour:Int = 12) extends TimeOfDay

Morning().startHour
Afternoon(16).startHour









