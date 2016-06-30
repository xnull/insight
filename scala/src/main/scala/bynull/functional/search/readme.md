### Functional and procedural ways to search first occurrence in the lists.

###### The task
Let's suppose that there are two groups of people. A man maybe in both groups. 
It's needed to find the first man from the first group who is in the second group too. 

###### Algorithm
Given two lists, it's required to find the first element from the first list which is contained in the second list.
We need to go through the first list until the first occurrence of the element in the second list.

**[Main class which runs all the examples](SearchApp.scala)**

#### Java

```java
for (Man manFromFirstGroup : firstGroup) {
            System.out.println("Get and handle current user from the first group: " + manFromFirstGroup.name());

            System.out.println(String.format(" - Looking for the man: '%s' in the second group", manFromFirstGroup.name()));
            if (!secondGroup.contains(manFromFirstGroup)){
                System.out.println(String.format(" - '%s' not found in the second group", manFromFirstGroup.name()));
                continue;
            }

            System.out.println(String.format(" - A match was found: '%s'", manFromFirstGroup.name()));
            return Optional.of(manFromFirstGroup);
        }

        System.out.println("There is no a man who stay in both groups");
        return Optional.empty();
    }
```

* [Search with Java](JavaSearch.java) full code example


#### Scala

```scala
@tailrec
  def search(firstGroup: Seq[Man], secondGroup: Seq[Man]): Option[Man] = {
    println("Get and handle current user from the first group: " + firstGroup.head.name)

    firstGroup match {
      case manFromFirstGroup :: rest =>
        println(s" - Looking for the man: '${manFromFirstGroup.name}' in the second group")

        secondGroup.find(manFromSecondGroup => manFromFirstGroup == manFromSecondGroup) match {
          case foundPerson@Some(man) =>
            println(s" - A match was found: '${manFromFirstGroup.name}'")
            foundPerson
          case None =>
            println(s" - '${manFromFirstGroup.name}' not found in the second group")
            search(rest, secondGroup)
        }
      case Nil =>
        println("There is no a man who stay in both groups")
        None
    }
  }
```

* [Functional search with scala](ScalaFunctionalSearch.scala) full code example
* [Procedural search with scala](ScalaProceduralSearch.scala) full code example
