package com.cc.study.design.proxy.lazyload;

/**
 * @Author: hecongcong
 * @Description:
 * 以一个简单的示例来阐述使用代理模式实现延迟加载的方法及其意义。假设某客户端软件有根据用户请求去数据库查询数据的功能。在查询数据前，需要获得数据库连接，软件开启时初始化系统的所有类，此时尝试获得数据库连接。当系统有大量的类似操作存在时 (比如 XML 解析等)，所有这些初始化操作的叠加会使得系统的启动速度变得非常缓慢。为此，使用代理模式的代理类封装对数据库查询中的初始化操作，当系统启动时，初始化这个代理类，而非真实的数据库查询类，而代理类什么都没有做。因此，它的构造是相当迅速的。
 *
 * 在系统启动时，将消耗资源最多的方法都使用代理模式分离，可以加快系统的启动速度，减少用户的等待时间。而在用户真正做查询操作时再由代理类单独去加载真实的数据库查询类，完成用户的请求。这个过程就是使用代理模式实现了延迟加载。
 *
 * 延迟加载的核心思想是：如果当前并没有使用这个组件，则不需要真正地初始化它，使用一个代理对象替代它的原有的位置，只要在真正需要的时候才对它进行加载。使用代理模式的延迟加载是非常有意义的，首先，它可以在时间轴上分散系统压力，尤其在系统启动时，不必完成所有的初始化工作，从而加速启动时间；其次，对很多真实主题而言，在软件启动直到被关闭的整个过程中，可能根本不会被调用，初始化这些数据无疑是一种资源浪费。例如使用代理类封装数据库查询类后，系统的启动过程这个例子。若系统不使用代理模式，则在启动时就要初始化 DBQuery 对象，而使用代理模式后，启动时只需要初始化一个轻量级的对象 DBQueryProxy。
 *
 * 下面代码 IDBQuery 是主题接口，定义代理类和真实类需要对外提供的服务，定义了实现数据库查询的公共方法 request() 函数。DBQuery 是真实主题，负责实际的业务操作，DBQueryProxy 是 DBQuery 的代理类。
 * @Date: 2018/6/7 上午 11:21
 * @Modifeid By:
 */
public class Main {

    public static void main(String[] args) {
        //此时并未创建真实对象
        IDBQuery query=new DBQueryProxy();
        //需要的时候创建真实对象
        String result = query.request();
        System.out.println(result);
    }

}


