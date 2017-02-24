package plex

/**
  * Created by salim on 2/24/2017.
  */
object PlexDataSource extends Enumeration {
  // Enumeration which represents the various sources of data
  // from which data can originate.
  type PlexDataSource = Value
  val RemoteRisk, PlexAdjustment = Value

}

