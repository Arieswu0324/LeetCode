public class Singleton {
    private Singleton() {
    }

    //静态内部类不持有外部类的引用
    //如果 Holder 是非静态的，需要先有 Singleton 实例才能创建 Holder 实例，陷入循环
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}