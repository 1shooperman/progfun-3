package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)

    val L4 = Leaf('E', 1)
    val R4 = Leaf('F', 1)

    val L5 = Leaf('G', 1)
    val R5 = Leaf('H', 1)

    val L2 = Fork(L4, R4, "EF".toList, 2)
    val R2 = Fork(L5, R5, "GH".toList, 2)

    val L3 = Leaf('C', 1)
    val R3 = Leaf('D', 1)

    val L1 = Leaf('B', 3)
    val R1 = Fork(L3, R3, "CD".toList, 2)

    val LEFT = Fork(L1, R1, "BCD".toList, 5)
    val RIGHT = Fork(L2, R2, "EFGH".toList, 4)

    val tree = Fork(Leaf('A', 8), Fork(LEFT, RIGHT, "BCDEFGH".toList, 9), "ABCDEFGH".toList, 17)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("times from comments") {
    val xs: List[(Char, Int)] = List(('a', 2), ('b', 1))
    assert(times(List('a', 'b', 'a')) === xs)
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("singleton false") {
    new TestTrees {
      assert(singleton(List(t1, t2)) === false)
    }
  }

  test("singleton true") {
    new TestTrees {
      assert(singleton(List(t1)) === true)
    }
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("decode from assignment details") {
    val bits: List[Bit] = List(1, 0, 0, 0, 1, 0, 1, 0)
    new TestTrees {
      assert(decode(tree, bits) === "BAC".toList)
    }
  }

  test("encode from assignment details") {
    new TestTrees {
      assert(encode(tree)("D".toList) === List(1, 0, 1, 1))
    }
  }

  test("encode from assignment details expanded") {
    new TestTrees {
      assert(encode(tree)("DD".toList) === List(1, 0, 1, 1, 1, 0, 1, 1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
