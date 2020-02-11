package com.knoldus

case class Student(id:Int,name:String)
case class Marks(subjectId:Int,studentId:Int,marks:Int)

class EvaluateStrategy{

  /*def passOrFailCount(marks:List[Marks],subjectId:Int,expectedResult:String,percent:Int):List[Int] = {
    expectedResult match {
      case "pass" =>  for (increment <- marks if (increment.subjectId == subjectId && increment.marks >= percent)) yield {increment.subjectId}

      case "fail" =>  for (increment <- marks if (increment.subjectId == subjectId && increment.marks < percent)) yield {increment.subjectId}
    }

  }*/


 /* def topBottomDisplay(student: List[Student],marks:List[Marks],subjectId:Int,count:Int,level:String): List[(String,Int)]=
    {
      level match {
           case "top" => val returnElements = for{ i<-marks.sortBy(_.marks)
                   j<-student
                   if (i.subjectId==subjectId && i.studentId==j.id)
                     m=(j.name,i.marks)
           }yield  m

             (returnElements.reverse).take(count)

           case "bottom" => val returnElements = for{ i<-marks.sortBy(_.marks)
                                                   j<-student
                                                   if (i.subjectId==subjectId && i.studentId==j.id)
                                                   m=(j.name,i.marks)
                                                   }yield  m

             (returnElements).take(count)



      }

    }
*/

  def topOrBottomCount(marks: List[Marks],student: List[Student],count:Int):Any={

    val joined = (student++marks) groupBy { case x: Student => x.id case y: Marks => y.studentId }
     println(joined)

    }



}

object EvaluateStrategy extends App {
  val student = List(Student(1, "kunal"), Student(2, "Himanshu"), Student(3, "Geetika"),
    Student(4, "Nitin"), Student(6, "Sparsh"), Student(7, "Nischal"),
    Student(8, "Krishna"), Student(9, "Arun"), Student(10, "Kartik")
  )

  val marks = List(Marks(1, 1, 95), Marks(2, 1, 75), Marks(3, 1, 71), Marks(4, 1, 79), Marks(5, 1, 81),
    Marks(1, 2, 59), Marks(2, 2, 39), Marks(3, 2, 65), Marks(4, 2, 99), Marks(5, 2, 80),
    Marks(1, 3, 91), Marks(2, 3, 72), Marks(3, 3, 12), Marks(4, 3, 73), Marks(5, 3, 30),
    Marks(1, 4, 90), Marks(2, 4, 61), Marks(3, 4, 37), Marks(4, 4, 75), Marks(5, 4, 85),
    Marks(1, 6, 97), Marks(2, 6, 17), Marks(3, 6, 41), Marks(4, 6, 69), Marks(5, 6, 78),
    Marks(1, 7, 49), Marks(2, 7, 19), Marks(3, 7, 25), Marks(4, 7, 49), Marks(5, 7, 65),
    Marks(1, 8, 11), Marks(2, 8, 32), Marks(3, 8, 62), Marks(4, 8, 33), Marks(5, 8, 50),
    Marks(1, 9, 70), Marks(2, 9, 21), Marks(3, 9, 47), Marks(4, 9, 55), Marks(5, 9, 55),
    Marks(1, 10, 87), Marks(2, 10, 47), Marks(3, 10, 71), Marks(4, 10, 79), Marks(5, 10, 90)
  )
  val evaluatePassOrFail=new EvaluateStrategy
  println(evaluatePassOrFail.topOrBottomCount(marks,student,2))

}