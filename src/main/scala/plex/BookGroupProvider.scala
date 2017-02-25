package plex

/**
  * Created by salim on 2/25/2017.
  */
trait BookGroupProvider {
  def getBookGroupForBook(book:String):String
}
