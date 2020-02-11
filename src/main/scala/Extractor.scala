package com.knoldus

class Extractor
  


object Extractor extends App {

  val dateExample = Date(12,2,2020,12,12,12)
  val Date(day) = dateExample
  println(day)
  URL("https","aws.amazon.com","/console/home",Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))
  val URL(protocol,domain,path,params)="https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112"
  println(protocol+" "+domain+" "+path+" "+params)
  val Email(username,domain1)= "nischalvasisth6@gmail.com"
  println(username+" "+domain1)
}

object Email {

  val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

  def unapply(arg: String): Option[(String,String)] = arg match {
    case null => None
    case e if e.trim.isEmpty => None
    case e if emailRegex.findFirstMatchIn(e).isDefined => {
      val temp = e.split("@"); Some(temp(0), temp(1))
    }
    case _ => None
  }

}
object Date {
  // The injection method (optional)
  def apply(dd: Int, mm: Int, yy: Int, HH: Int, MM: Int, SS: Int) = dd + "-" + mm + "-" + yy + ":" + HH + ":" + MM + ":" + SS

  // The extraction method (mandatory)
  def unapply(str: String): Option[String] = {
    val parts = str split "-"
    if (parts.length == 3) Some(parts(0)) else None
  }
}

object URL {
  def apply(protocol: String, domain: String, path: String,
            params: Map[String, String]): String = {

    protocol + "://" + domain + "" + path + "?" + params.map { case (k, v) => k + "=" + v }.mkString("&")

  }

  def unapply(url: String): Option[(String, String,
    String, Map[String, String])] = {
    //definition
    val temp = url.split("://")

    def finalMap(temMap: Map[String, String], a: Array[String]): Map[String, String] = {
      if (a.length > 1) finalMap(temMap ++ Map(a(0) -> a(1)), a.slice(2, a.length))
      else temMap
    }

    if (temp.length >= 1) {

      val some1 = temp(1).split("(?<=com)")
      val some2 = some1(1).split("[?]")
      val tempArray = some2(1).split("[=\\&]")
      val result = finalMap(Map.empty[String, String], tempArray)
      Some(temp(0), some1(0), some2(0), result)
   }
  else None
  }
}


