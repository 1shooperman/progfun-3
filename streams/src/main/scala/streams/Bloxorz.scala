package streams

/**
 * A main object that can be used to execute the Bloxorz solver
 */
object Bloxorz extends App {

  /**
   * A level constructed using the `InfiniteTerrain` trait which defines
   * the terrain to be valid at every position.
   */
  object InfiniteLevel extends Solver with InfiniteTerrain {
    val startPos = Pos(1,3)
    val goal = Pos(5,8)
  }
  
  println(InfiniteLevel.solution)

  /**
   * A simple level constructed using the StringParserTerrain 
   */
  abstract class Level extends Solver with StringParserTerrain
  
  object Level0 extends Level {
    val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin
  }

  println(Level0.solution)

  /**
   * Level 1 of the official Bloxorz game
   */
  object Level1 extends Level {
    val level =
      """ooo-------
        |oSoooo----
        |ooooooooo-
        |-ooooooooo
        |-----ooToo
        |------ooo-""".stripMargin
  }

  println(Level1.solution)
  
  // from forums
  new Level with SolutionVisualizer {
    val level = Level1.level
    displaySolution(solution)
  }
  
  // from forums
  trait SolutionVisualizer extends GameDef with Solver with StringParserTerrain {
    def clearScreen: Unit = print("\033[2J\033[1;1H")
    def cursorOff: Unit = print("\033[?25l")
    def cursorOn: Unit = print("\033[?25h")
    def printAt(x: Int, y: Int, c: Char): Unit = {
      print("\033[" + (x + 1) + ";" + (y + 1) + "H" + c)
    }

    def printBlock(b: Block, c: Char): Unit = {
      def clearAndPrintAt(p: Pos, c: Char): Unit = {
        if (c == '\000') printAt(p.x, p.y, vector(p.x)(p.y))
        else printAt(p.x, p.y, c)
      }

      if (!b.isStanding) {
        clearAndPrintAt(b.b1, c)
      }
      clearAndPrintAt(b.b2, c)
    }

    def displayBlock(b: Block): Unit = {
      printBlock(b, '#')
      Thread.sleep(1000)
      printBlock(b, '\000')
    }

    def displayTerrain(levelVector: Vector[Vector[Char]]): Unit = {
      for (i <- 0 to levelVector.size - 1; j <- 0 to levelVector(i).size - 1) {
        printAt(i, j, levelVector(i)(j))
      }
      println
    }

    def displaySolution(ls: List[Move]): Unit = {
      clearScreen
      cursorOff
      displayTerrain(vector)
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => { displayBlock(block); block.left }
          case Right => { displayBlock(block); block.right }
          case Up => { displayBlock(block); block.up }
          case Down => { displayBlock(block); block.down }
        }
      }
      displayTerrain(vector)
      cursorOn
    }

  }
}
