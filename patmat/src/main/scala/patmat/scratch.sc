package patmat

import Huffman._

object scratch {
  decodedSecret.mkString                          //> res0: String = huffmanestcool

  val test = new someTest                         //> test  : patmat.someTest = patmat.someTest@39b5e7a0
  
  makeOrderedLeafList(Nil)                        //> res1: List[patmat.Huffman.Leaf] = List()
  
  convert(test.t1)                                //> res2: patmat.Huffman.CodeTable = List((a,List(0)), (b,List(1)))
  
  convert(test.tree)                              //> res3: patmat.Huffman.CodeTable = List((A,List(0)), (B,List(1, 0, 0)), (C,Lis
                                                  //| t(1, 0, 1, 0)), (D,List(1, 0, 1, 1)), (E,List(1, 1, 0, 0)), (F,List(1, 1, 0,
                                                  //|  1)), (G,List(1, 1, 1, 0)), (H,List(1, 1, 1, 1)))
  codeBits(convert(test.tree))('B')               //> res4: List[patmat.Huffman.Bit] = List(1, 0, 0)
  
  mergeCodeTables(convert(test.t1), convert(test.t2))
                                                  //> res5: patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (d,Lis
                                                  //| t(1)))
  
  combine(Nil)                                    //> res6: List[patmat.Huffman.CodeTree] = List()
}

class someTest extends TestTrees {
}

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