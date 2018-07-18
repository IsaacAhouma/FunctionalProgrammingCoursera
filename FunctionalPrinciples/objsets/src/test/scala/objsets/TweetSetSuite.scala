package objsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val set1 = new Empty
    val set= set1.incl(new Tweet("a", "a body", 10))
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val e = new Tweet("e", "e body", 1000)
    val f = new Tweet("f", "f body", 1001)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)
    val set6 = set5.incl(e)
    val set7 = set6.incl(f)
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("filter: 20 on set6") {
    new TestSets {
      assert(size(set6.filter(tw => tw.retweets == 1000)) === 1)
    }
  }

  test("filter: 20 on set6 (2)") {
    new TestSets {
      assert(size(set6.filter(tw => tw.retweets == 1001)) === 0)
    }
  }


  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("mostRetweets: with non empty set (1)") {
    new TestSets {
      assert(set4c.mostRetweeted.retweets === 20)
    }
  }

  test("mostRetweets: with non empty set (3)") {
    new TestSets {
      assert(set.mostRetweeted.retweets === 10)
    }
  }

  test("mostRetweets: with non empty set (4)") {
    new TestSets {
      assert(set6.mostRetweeted.retweets === 1000)
    }
  }

  test("mostRetweets: with non empty set (5)") {
    new TestSets {
      assert(set7.mostRetweeted.retweets === 1001)
    }
  }

  test("descending: set5") {
    new TestSets {
      val trends = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }

  test("descending: set6") {
    new TestSets {
      val trends = set6.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "e" )
    }
  }

  test("descending: set1") {
    new TestSets {
      val trends = set1.descendingByRetweet
      assert(trends.isEmpty)
    }
  }

  }
