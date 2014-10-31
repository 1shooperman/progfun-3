package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => block.left
          case Right => block.right
          case Up => block.up
          case Down => block.down
        }
      }

    // so I don't have to keep typing the full word
    lazy val u = Up
    lazy val r = Right
    lazy val l = Left
    lazy val d = Down
  }

  trait Level1 extends SolutionChecker {
    /* terrain for level 1*/

    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  trait Level3 extends SolutionChecker {
    /* terrain for level 3,4,6 -- from forums https://class.coursera.org/progfun-005/forum/thread?thread_id=938 */

    val level =
      """---------------  
      |------ooooooo--
      |oooo--ooo--oo--
      |ooooooooo--oooo
      |oSoo-------ooTo 
      |oooo-------oooo
      |------------ooo""".stripMargin

    val optsolution = List(r, u, r, r, r, u, l, d, r, u, u, r, r, r, d, d, d, r, u)
  }

  trait Level4 extends SolutionChecker {
    val level =
      """---------------  
      |---ooooooo----
      |---ooooooo----
      |oooo-----ooo--
      |ooo-------oo--
      |ooo-------oo--
      |oSo--ooooooooo
      |ooo--ooooooooo
      |-----oTo--oooo
      |-----ooo--oooo""".stripMargin

    val optsolution = List(u, l, u, r, r, u, r, r, r, r, r, r, d, r, d, d, d, d, d, r, u, l, l, l, l, l, l, d)
  }

  trait Level6 extends SolutionChecker {
    val level =
      """---------------
    |-----oooooo----
    |-----o--ooo----
    |-----o--ooooo--
    |Sooooo-----oooo
    |----ooo----ooTo
    |----ooo-----ooo
    |------o--oo----
    |------ooooo----
    |------ooooo----
    |-------ooo-----""".stripMargin

    val optsolution = List(r, r, r, d, r, d, d, r, d, d, r, u, l, l, l, u, u, l, u, u, u, r, r, r, d, d, r, d, r, r, r, d, l, u, u, r, d, l, u, d, r)
  }

  // level 1 tests
  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0, 0)), "0,0")
      assert(!terrain(Pos(4, 11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1, 1))
    }
  }

  test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }

  // from forums https://class.coursera.org/progfun-005/forum/thread?thread_id=908
  test("check level 1 neighbors") {
    new Level1 {
      assert((startBlock.neighbors) === List((startBlock.left, Left), (startBlock.right, Right), (startBlock.up, Up), (startBlock.down, Down)))
    }
  }

  // from forums https://class.coursera.org/progfun-005/forum/thread?thread_id=908
  test("check level 1 localNeighbors") {
    new Level1 {
      assert((startBlock.legalNeighbors) === List((startBlock.right, Right), (startBlock.down, Down)))
    }
  }

  // level 3
  test("level 3 solution") {
    new Level3 {
      assert(solution.length == optsolution.length)
    }
  }

  // level 4
  test("level 4 solution") {
    new Level4 {
      assert(solution.length == optsolution.length)
    }
  }

  // level 6
  test("level 6 solution") {
    new Level6 {
      assert(solution.length == optsolution.length)
    }
  }
}
