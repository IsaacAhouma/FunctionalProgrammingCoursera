package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("weight of t2") {
    new TestTrees {
      assert(weight(t2) === 9)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("singleton 1") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(singleton(leaflist) === false)
  }

  test("singleton 2") {
    val leaflist = List(Leaf('e', 1))
    assert(singleton(leaflist) === true)
  }



//  test("count frequencies") {
//    assert(times(string2Chars("abbaaabca")) === List(("a",5),("b",3),("c",1)))
//  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("combine of some leaf list 2") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(combine(leaflist)) === List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),Leaf('x',4),List('e','t','x'),7)))
  }

  test("combine of some leaf list 3") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4))) === List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),Leaf('x',4),List('e','t','x'),7)))
  }

  test("until 1") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(until(singleton,combine)(leaflist) === List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),Leaf('x',4),List('e','t','x'),7)))
  }

  test("create CodeTree") {
    val leaflist = List('e','t','t','x','x','x','x')
    assert(createCodeTree(leaflist) === Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),Leaf('x',4),List('e','t','x'),7))
  }


  test("decode a very short text") {
    new TestTrees {
      assert(decode(t1, List(0,1,1,0,1,0)) === "abbaba".toList)
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode long text") {
    new TestTrees {
      assert(decode(frenchCode, encode(frenchCode)("huffmanestcool".toList)) === "huffmanestcool".toList)
    }
  }

  test("encode long text") {
    new TestTrees {
      assert(encode(frenchCode)("huffmanestcool".toList) === secret)
    }
  }

  test("decodedSecret") {
    new TestTrees {
      assert(decodedSecret === "huffmanestcool".toList)
    }
  }

  test("convert gives right result"){
    new TestTrees {
      val ct1: CodeTable = List(('a',List(0)),('b',List(1)))
      assert(convert(t1).equals(ct1))
    }
  }

  test("check encode and quick encode have same result") {
    new TestTrees {
      assert(encode(frenchCode)("huffmanestcool".toList).equals(quickEncode(frenchCode)("huffmanestcool".toList)))
    }
  }

}
