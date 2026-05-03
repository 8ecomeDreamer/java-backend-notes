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



    public static class noArgsConstructor {

        private String argsName;

        public noArgsConstructor() {
            System.out.println("无参构造函数,由编译器默认创建 ");
        }

        public String getArgsName() {
            return this.argsName;
        }

    }




    public static class argsConstructor {

        private String argsName;

        public argsConstructor(String argsName) {
            System.out.println("有参构造函数，必须要传入固定的参数，否则报错");
            this.argsName = argsName;
        }

        public String getArgsName() {
            return this.argsName;
        }

        public String setArgsName() {
            return this.argsName;
        }

    }

    public static class overloadingConstructor {
        private String name;
        private int age;
        private String sex;

        public overloadingConstructor(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public overloadingConstructor(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void out() {
            System.out.println("姓名 " + name + " 年龄 " + age + " 性别 " + sex);
        }

    }



    public static class cloneConstructor implements Cloneable{
        private String animal;
        private String variety;

        public String getAnimal() {
            return animal;
        }

        private void setAnimal(String animal) {
            this.animal = animal;
        }

        private String getVariety() {
            return variety;
        }

        private void setVariety(String variety) {
            this.variety = variety;
        }

        public cloneConstructor(String animal, String variety) {
            this.animal = animal;
            this.variety = variety;
        }
        public cloneConstructor(cloneConstructor cloneConstructor) {
            this.animal = cloneConstructor.getAnimal();
            this.variety = cloneConstructor.getVariety();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            // clone方法不能直接调用，必须通过重载和super关键字才能调用
            return super.clone();
        }
        public void out() {
            System.out.println("这是一个 " + animal  + " 它的品种是 " + variety );
        }

    }

    public static void classConstructor() throws CloneNotSupportedException {
        System.out.println();
        System.out.println("构造方法：Java 有两种类型的构造方法：无参构造方法和有参构造方法。");
        System.out.println("创建构造方法的规则：");
        System.out.println("1.构造方法的名字必须和类名一样");
        System.out.println("2.构造方法没有返回类型，包括 void");
        System.out.println("3.构造方法不能是抽象的（abstract）、静态的（static）、最终的（final）、同步的（synchronized）。");

        noArgsConstructor noArgsConstructor = new noArgsConstructor();
        System.out.println("无参构造方法演示：" + noArgsConstructor.getArgsName());

        argsConstructor argsConstructor = new argsConstructor("有参构造方法");
        System.out.println("有参构造方法演示：" + argsConstructor.getArgsName());

        overloadingConstructor overloadingConstructor1 = new overloadingConstructor("coderWorld",25, "男");
        overloadingConstructor overloadingConstructor2 = new overloadingConstructor("coderWorld",25);

        System.out.println("重载构造函数方法演示：");
        overloadingConstructor1.out();
        overloadingConstructor2.out();

        System.out.println("构造函数方法与方法区别：");
        System.out.println("1.构造函数没有返回值，方法有返回值");
        System.out.println("2.构造函数必须与类名同名，方法不一定同名");
        System.out.println("3.构造函数由编译器隐式调用，方法由开发者显示调用");
        System.out.println("4.构造函数由编译器或开发者提供，方法由开发者提供");
        System.out.println("5.构造函数一般用于初始化对象的字段，方法由开发者定义作用");

        System.out.println("对象的复制：");
        System.out.println("1.构造函数复制：");
        cloneConstructor cloneConstructor1 = new cloneConstructor("狗", "泰迪");
        cloneConstructor cloneConstructor2 = new cloneConstructor(cloneConstructor1);
        cloneConstructor2.out();
        System.out.println("2.对象复制：");
        cloneConstructor cloneConstructor3 = new cloneConstructor("狗", "柯基");
        cloneConstructor cloneConstructor4 = new cloneConstructor("狗", "哈士奇");
        System.out.println("复制前：");
        cloneConstructor4.out();
        cloneConstructor4.setAnimal(cloneConstructor3.getAnimal());
        cloneConstructor4.setVariety(cloneConstructor3.getVariety());
        System.out.println("复制后：");
        cloneConstructor4.out();
        System.out.println("2.clone方法：");
        cloneConstructor cloneConstructor5 = new cloneConstructor("猫", "无毛猫");
        cloneConstructor cloneConstructor6  = (cloneConstructor) cloneConstructor5.clone();
        cloneConstructor6.out();

    }

    public static void classAccessControl() {
        System.out.println();
        System.out.println("在 Java 中，提供了四种访问权限控制：");
        System.out.println("默认访问权限（包访问权限）\n" +
                "public\n" +
                "private\n" +
                "protected");
        System.out.println("这些修饰符可以修饰类和方法和变量");
        System.out.println("默认访问权限（包访问权限）：如果一个类的方法或变量被包访问权限修饰，也就意味着只能在同一个包中的其他类中显示地调用该类的方法或者变量，在不同包中的类中不能显式地调用该类的方法或变量。\n" +
                "private：如果一个类的方法或者变量被 private 修饰，那么这个类的方法或者变量只能在该类本身中被访问，在类外以及其他类中都不能显式的进行访问。\n" +
                "protected：如果一个类的方法或者变量被 protected 修饰，对于同一个包的类，这个类的方法或变量是可以被访问的。对于不同包的类，只有继承于该类的类才可以访问到该类的方法或者变量。\n" +
                "public：被 public 修饰的方法或者变量，在任何地方都是可见的。");
    }

    public static class classCodeInitA {
        classCodeInitA () {
            System.out.println("父类构造方法");
        }
    }
    public static class classCodeInitB extends classCodeInitA{
        classCodeInitB() {
            System.out.println("子类构造方法");
        }

        {
            System.out.println("代码初始化块");
        }

        public static void main(String[] args) {
            new classCodeInitB();
        }
    }

    public static void classCodeInit() {
        System.out.println();
        System.out.println("代码初始化块：（了解执行即可）");
        new classCodeInitB();
        System.out.println("静态初始化块在类加载时执行，只会执行一次，并且优先于实例初始化块和构造方法的执行；实例初始化块在每次创建对象时执行，在构造方法之前执行");
    }


    public static void classAbstract() {
        System.out.println();
        System.out.println("定义:定义抽象类的时候需要用到关键字 abstract，放在 class 关键字前。《阿里的 Java 开发手册》上有强调，抽象类命名要使用 Abstract 或 Base 开头");
        System.out.println("特征:抽象类是不能实例化的，尝试通过 new 关键字实例化的话，编译器会报错，虽然抽象类不能实例化，但可以有子类。子类通过 extends 关键字来继承抽象类。");
        System.out.println("应用场景:");
        System.out.println("1.当我们希望一些通用的功能被多个子类复用的时候，就可以使用抽象类。");
        System.out.println("2.当我们需要在抽象类中定义好 API，然后在子类中扩展实现的时候就可以使用抽象类。");
        System.out.println("总结:");
        System.out.println("1.抽象类不能被实例化。");
        System.out.println("2.抽象类必须有一个抽象方法，且该方法必须在继承的子类中实现。");
        System.out.println("3.抽象类没有方法体。");
    }

    public static void interfaceClass() {
        System.out.println();
    }


    public static void innerClass() {
        System.out.println();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        classIntroduce();
        classCreate();
        classObjectMethod();
        classVariable();
        classMethod();
        classNativeMethod();
        classConstructor();
        classAccessControl();
        classCodeInit();
        classAbstract();
        interfaceClass();
        innerClass();
    }
}
