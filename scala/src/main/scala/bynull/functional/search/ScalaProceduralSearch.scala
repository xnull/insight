package bynull.functional.search

/**
  * Created by bynull on 30.06.16.
  */
object ScalaProceduralSearch {

  /**
    * Procedural search in scala
    */
  def search(firstGroup: Seq[Man], secondGroup: Seq[Man]): Option[Man] = {
    var found = false
    var index = 0
    var foundPerson: Option[Man] = None

    while (!found) {
      println("Get and handle current user from the first group: " + firstGroup(index))

      val manFromFirstGroup = firstGroup(index)

      println(s" - Looking for the man: '${manFromFirstGroup.name}' in the second group")
      if (secondGroup.contains(manFromFirstGroup)) {
        println(s" - A match was found: '${manFromFirstGroup.name}'")
        found = true
        foundPerson = Some(manFromFirstGroup)
      } else {
        println(s" - '${manFromFirstGroup.name}' not found in the second group")
        index += 1
      }
    }

    foundPerson
  }
}
