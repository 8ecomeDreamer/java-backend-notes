package com.study.basic;

public class ClassExample {

    private String name;

    public ClassExample(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public static void classIntroduce() {
        System.out.println();
        System.out.println("OOP：Object-Oriented programming，面向对象编程");
        System.out.println("类一般包含：变量、方法、构造函数");
    }

    public static void classCreate() {
        System.out.println();
        System.out.println("初始化对象（引用对象初始化、内部方法初始化、构造方法初始化，个人认为掌握熟记第三种即可。）");
        ClassExample classExample = new ClassExample("构造方法创建");
        System.out.println("ClassExample初始化: " + classExample.getName());
    }

    public static void classObjectMethod() {
        System.out.println();
        System.out.println("对象的方法（可以根据场景去记，对于线程的操作一般有: 比较、克隆、转字符串、多线程、反射）");
        System.out.println("hashCode、equals、clone、toString、wait等");
    }


    public static void classVariable() {
        System.out.println();
        System.out.println("变量：：局部变量、成员变量、静态变量。");
        System.out.println("局部变量：在方法体内声明的变量被称为局部变量，该变量只能在该方法内使用。局部变量是在栈上分配的。局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。");
        System.out.println("成员变量：在类内部但在方法体外声明的变量称为成员变量，或者实例变量，或者字段。之所以称为实例变量，是因为该变量只能通过类的实例（对象）来访问。当一个对象被实例化之后，每个成员变量的值就跟着确定。成员变量可以声明在使用前或者使用后。成员变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把成员变量设为私有。通过使用访问修饰符可以使成员变量对子类可见；成员变量具有默认值。数值型变量的默认值是 0，布尔型变量的默认值是 false，引用类型变量的默认值是 null。变量的值可以在声明时指定，也可以在构造方法中指定。");
        System.out.println("静态变量：通过 static 关键字声明的变量被称为静态变量（类变量），它可以直接被类访问。静态变量储存在静态存储区。静态变量除了被声明为常量外很少使用。");
        System.out.println("常量：在 Java 中，有些数据的值是不会发生改变的，这些数据被叫做常量——使用 final 关键字修饰的成员变量。常量的值一旦给定就无法改变！Java 要求常量名必须大写。常量在程序运行过程中主要有 2 个作用：1.代表常数，便于修改（例如：圆周率的值，final double PI = 3.14）2.增强程序的可读性（例如：常量 UP、DOWN 用来代表上和下，final int UP = 0）");
    }


    public static void classMethod() {
        System.out.println();
        System.out.println("方法可以分为两种，一种叫标准类库方法，一种叫用户自定义方法。");
        System.out.println("实例方法：没有使用 static 关键字修饰，但在类中声明的方法被称为实例方法，在调用实例方法之前，必须创建类的对象。");
        System.out.println("静态方法：有 static 关键字修饰的方法就叫做静态方法。");
        System.out.println("抽象方法：没有方法体的方法被称为抽象方法，它总是在抽象类中声明。这意味着如果类有抽象方法的话，这个类就必须是抽象的。可以使用 abstract 关键字创建抽象方法和抽象类。");
    }


    public static void classNativeMethod() {
        System.out.println();
        System.out.println("Native方法");
        System.out.println("JNI：Java Native Interface");
    }


    public static void classConstructor() {
        System.out.println();
        System.out.println("构造方法：Java 有两种类型的构造方法：无参构造方法和有参构造方法。");
        System.out.println("创建构造方法的规则：");
        System.out.println("1.构造方法的名字必须和类名一样");
        System.out.println("1.构造方法没有返回类型，包括 void");
        System.out.println("1.构造方法不能是抽象的（abstract）、静态的（static）、最终的（final）、同步的（synchronized）。");
    }


    public static void main(String[] args) {
        classIntroduce();
        classCreate();
        classObjectMethod();
        classVariable();
        classMethod();
        classNativeMethod();
        classConstructor();
    }
}
