package example

class Rational(x: Int, y: Int) {
//  require(y < 0, "Denominator must be positive")
  
  // Constructor
  def this(x: Int) = this(x, 1)
  
  // Fields
  private def gcd(a: Int, b:Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  
  def numer = x / g
  def denom = y / g
  
  def less(that: Rational) = numer * that.denom < that.numer * denom
  def < (that: Rational) = numer * that.denom < that.numer * denom
  
  def max(that: Rational) = if(this.less(that)) that else this
  
  def neg: Rational = new Rational(-numer, denom)
  
  def add(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def + (that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  
  def sub(that: Rational) = add(that.neg)
    
  override def toString = numer + "/" + denom
  
}