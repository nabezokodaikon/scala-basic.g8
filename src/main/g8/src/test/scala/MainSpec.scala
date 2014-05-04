import org.specs2._

class MainSpec extends Specification { def is = s2"""

  Main object 
    This is test of the example method.     \$e1
  """

  import $organization$._
  
  def e1 = Main.helloWorld("Taro") === "Hello Taro!" 
}
