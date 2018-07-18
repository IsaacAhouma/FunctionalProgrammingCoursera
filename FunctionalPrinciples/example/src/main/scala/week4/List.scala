package week4

import week3._

object List {
//  def List[T]() = new Nil[T]
//  def List[T](x: T) = new Cons[T](x,new Nil[T])
//  def List[T](x: T,y: T) = new Cons[T](x,new Cons[T](y,new Nil[T]))
  def apply[T]() = new Nil[T]
  def apply[T](x: T) = new Cons[T](x,new Nil[T])
  def apply[T](x: T,y: T) = new Cons[T](x,new Cons[T](y,new Nil[T]))


}
