package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/3.
 */
public class StormyInning extends Inning implements Storm {
    //可以给构造器抛出新的异常，但是派生类的构造器的异常中，必须包含基类构造器的异常
    public StormyInning() throws RainedOut, BaseballException {   }

    public StormyInning(String s) throws Foul, BaseballException {   }

    //常规方法必须遵从基类 (这个例子什么意思，去掉public让编译错误？这和异常有什么关系？)
    // void walk() throws PopFoul {   }

    //接口不能给基类中已经存在的方法添加异常
    // public void event() throws RainedOut {   }

    //如果接口中的方法在基类中不存在，那么就可以添加异常
    public void rainHard() throws RainedOut {   }

    //虽然基类中该方法抛出的有异常，但是这里可以选择不抛出
    public void event() {   }

    //重载的方法可以抛出基类中抛出的异常的子类
    public void atBat() throws PopFoul {   }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        //派生类中Strike没有被抛出
        try {
            Inning i = new StormyInning();  //向上转型后会发生什么？
            i.atBat();
            //必须捕获基类版本中该方法抛出的异常 (可为什么我把Strike和Foul两个catch都删掉了，依然编译通过？)
            //(好像与Strike和Foul继承BaseballException有关)(这个就是上边哪个atBat()方法的注释，即重载的方法可以抛出基类中抛出的异常的子类)
        } catch (Strike strike) {
            strike.printStackTrace();
        } catch (Foul foul) {
            foul.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }

    }



}
