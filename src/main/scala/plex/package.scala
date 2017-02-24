/**
  * Created by salim on 2/24/2017.
  */
package object plex {

  implicit def ccyFromString(ccyName: String): Currency = {
    Currency(ccyName)
  }

}
