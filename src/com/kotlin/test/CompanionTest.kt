package com.kotlin.test

class CompanionTest {


    /**
     * 依赖外部类，生成静态内部类，外部类持有companion的静态对象
     * 所以外部类可以直接访问companion内的属性和方法
     */
    companion object CompanionObject {
        var string: String = "CompanionObject"
        fun foo() = string
    }


}


fun main(args: Array<String>) {
    println("Singleton.foo()=>${CompanionTest.foo()}")
}


/**
 * java代码如下
 */
/*


public final class CompanionTest {
   @NotNull
   private static String string = "CompanionObject";
   public static final CompanionTest.CompanionObject CompanionObject = new CompanionTest.CompanionObject((DefaultConstructorMarker)null);

   public static final class CompanionObject {
      @NotNull
      public final String getString() {
         return CompanionTest.string;
      }

      public final void setString(@NotNull String var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CompanionTest.string = var1;
      }

      @NotNull
      public final String foo() {
         return ((CompanionTest.CompanionObject)this).getString();
      }

      private CompanionObject() {
      }

      // $FF: synthetic method
      public CompanionObject(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}





*/
