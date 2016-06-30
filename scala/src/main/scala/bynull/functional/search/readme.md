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
public static Optional<Man> search(List<Man> firstGroup, List<Man> secondGroup)  {
    for (Man manFromFirstGroup : firstGroup) {
        if (!secondGroup.contains(manFromFirstGroup)){
            continue;
        }

        return Optional.of(manFromFirstGroup);
    }

    return Optional.empty();
}
```

* [Search with Java](JavaSearch.java) full code example


#### Scala

```scala
@tailrec
def search(firstGroup: Seq[Man], secondGroup: Seq[Man]): Option[Man] = {

  firstGroup match {
    case manFromFirstGroup :: rest =>
      secondGroup.find(manFromSecondGroup => manFromFirstGroup == manFromSecondGroup) match {
        case foundPerson@Some(man) => foundPerson
        case None => search(rest, secondGroup)
      }
      case Nil => None
    }
}
```

* [Functional search with scala](ScalaFunctionalSearch.scala) full code example
* [Procedural search with scala](ScalaProceduralSearch.scala) full code example
