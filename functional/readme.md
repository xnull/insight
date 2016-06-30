Имеется 2 списка с элеметами необходимо найти первый элемент из первого списка который также содержится во втором списке.

It's required to go throught list1 and find the first occurence in the list2 from list1

## Functional way to find first occurence


###### The task
Имеется 2 списка с элеметами необходимо найти первый элемент из первого списка который также содержится во втором списке.
Let's suppose that there are two lists of elements. It's required to find first occurence in second list.  


###### Algorithm
Go through the first list and find first occurence in the second list.


#### Java:
```
public Optional<BlacklistEntity> find(String identValue, IdentType identType) {
        Set<Long> linkedIdentIds = identService.findAllLinkedIdentIds(identValue, identType);
        for (Long linkedIdentId : linkedIdentIds) {
            BlacklistEntity bl = blacklistRepo.findByIdentId(linkedIdentId);
            if (bl != null) {
                return Optional.of(bl);
            }
        }
```


#### Scala: 
```@tailrec
  private def findBl(linkedIdentIds: Seq[Long]): Option[Blacklist] = {
    linkedIdentIds match {
      case linkedIdentId :: tail =>
        blacklistRepo.findByIdentId(linkedIdentId) match {
          case bl@Some(x) => bl
          case None => findBl(tail)
        }
      case Nil => None
    }
  }
```
