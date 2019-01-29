package org.ms.thinkInJava.generics;

import java.util.List;

/**
 * Created by Ryan on 2017/10/27.
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples){
        //? super Apple 即表示为Apple或其任何基类，如Object
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit());  //Error

        //my test
        //既然通配符可能表示为Object，那么为什么这里不能加 Object 对象？
        //因为实际List所持有的类型可能为Apple或其任何基类，说明这个实际类型最低也是Apple，因此向List中添加Apple的子类，一定是类型安全的。
        //虽然说持有类型可能为 Object，此时要说向List中添加Fruit是没问题的，但是，这只是一种情况，不能完全保证类型安全。因此，Apple是下界，不能比它更高。
        // apples.add(new Object());

        //上界、下界都是相对通配符所表示的类型来说的。
        //但不论是上界、还是下界，所添加或使用的实例类型，肯定都是通配符所代表类型或其子类型
        //如上边的例子中，不论 ？ 是Apple还是Apple的哪个基类，最终向 apples 中添加的实例对象，一定是Apple的子类。
    }
}
