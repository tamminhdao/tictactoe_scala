package ttt
import org.scalatest.FunSuite

class ToBeDeletedSuite extends FunSuite {
  test ("can do sum") {
    assert(1 + 1 === 2)
  }

  test ("can do subtraction") {
    assert(ToBeDeleted.subtract(5, 1) === 4);
  }
}
