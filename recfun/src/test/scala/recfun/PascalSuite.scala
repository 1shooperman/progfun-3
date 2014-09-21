package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }

  test("pascal: bad row input") {
    assert(pascal(1, -1) === 0)
  }

  test("pascal: bad column input") {
    assert(pascal(-1, 1) === 0)
  }

  test("pascal: column out of range input") {
    assert(pascal(15, 0) === 0)
  }

  test("pascal: col=3, row=1") {
    assert(pascal(3, 1) === 0)
  }

  test("pascal: symmetry") {
    assert(pascal(0, 2) === 1)
    assert(pascal(2, 2) === 1)
  }
  
  test("pascal: base cases") {
    assert(pascal(0, 15) === 1)
    assert(pascal(0,0) === 1)
    assert(pascal(-1, -1) === 0)
  }
  
  test("pascal: extreme numbers") {
    assert(pascal(101, 1) === 0)
    assert(pascal(1,101) === 101)
    assert(pascal(999999999, 1) === 0)
    //assert(pascal(1, 999999999) === 3)
  }
}