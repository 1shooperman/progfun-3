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
    val u = Up
    val r = Right
    val l = Left
    val d = Down
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

    val optsolution = List(Right, Down, Down, Right, Down, Right, Right, Up, Left, Down, Down, Right, Right, Right, Up, Up, Up, Left, Up, Up, Left, Left, Left, Up, Right, Down, Down, Right, Down, Down, Right, Down, Right, Right, Right)
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
      assert(solve(solution) === Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }

  // from assignment
  test("You should implement the above example as a test case in the test suite BloxorzSuite.") {
    new Level1 {
      assert(neighborsWithHistory(Block(Pos(1, 1), Pos(1, 1)), List(Left, Up)).toSet === Set(
        (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))))
    }
  }

  // from assignment
  test("Again, you should convert this example into a test case.") {
    new Level1 {
      assert {
        newNeighborsOnly(
          Set(
            (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
            (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream,

          Set(Block(Pos(1, 2), Pos(1, 3)), Block(Pos(1, 1), Pos(1, 1)))) === Set(
            (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream

      }
    }
  }

  // from forums https://class.coursera.org/progfun-005/forum/thread?thread_id=908
  test("check level 1 neighbors") {
    new Level1 {
      assert((startBlock.neighbors) === List((startBlock.left, Left), (startBlock.right, Right), (startBlock.up, Up), (startBlock.down, Down)))
    }
  }

  // from forums https://class.coursera.org/progfun-005/forum/thread?thread_id=908
  test("check level 1 legalNeighbors") {
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
