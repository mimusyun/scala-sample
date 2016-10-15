package example

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
  def neg: Rational = new Rational(-numer, denom)
  
  def add(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  
  def sub(that: Rational) = add(that.neg)
    
  override def toString = numer + "/" + denom
  
}