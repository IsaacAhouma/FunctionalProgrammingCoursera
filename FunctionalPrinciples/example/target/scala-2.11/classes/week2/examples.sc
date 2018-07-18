object week2{

  class rational(x: Int, y: Int) {

    require(y!=0, "denominator must be non zero")

    private def gcd(a: Int, b:Int): Int = {
      if (b==0) a else gcd(b,a%b)
    }

    def this(x: Int) = this(x,1)

    private val g = gcd(x,y)
    def numer = x / g
    def denom = y / g

    def +(that: rational) = {
      new rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)
    }

    override def toString: String = {
      this.numer  + "/" + this.denom
    }

    def unary_- :rational = new rational(-this.numer,this.denom)

    def -(y: rational) = {
      this + -y
    }

    def <(that: rational) = {
      this.numer*that.denom < that.numer*this.denom
    }

    def max(that: rational) = {
      if (this < that) that else this
    }


  }

  def addRationals(r1: rational, r2: rational) = {
    new rational(r1.numer * r2.denom + r2.numer * r1.denom, r1.denom * r2.denom)
  }

  val x = new rational(1,3)
  val y = new rational(5,7)
  val z = new rational(3,2)

  addRationals(x,y).numer

  def makeString(r: rational) = {
    r.numer + "/" + r.denom
  }

//  makeString(x)


//  x.add(y).toString
//  x.add(y.neg).toString
//  x.substract(y).toString
//
//  x.add(y.neg.substract(z)).toString
//  x.substract(y.add(z)).toString
//  y.add(y)

  x + y
  x + -y
  x - y
  x - (y + z)
  x + (-y - z)
  x - y - z
  y + y


}