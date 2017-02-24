/**
  * Created by salim on 2/24/2017.
  */
package object risk {

  implicit def ccyFromString(ccyName: String): Currency = {
    Currency(ccyName)
  }

}
