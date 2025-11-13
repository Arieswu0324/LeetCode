import java.util.*;

class RandomizedSet {
    private final Random random;

    private final Set<Integer> set;

    private final List<Integer> list;

    public RandomizedSet() {
        this.random = new Random();
        this.set = new HashSet<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        list.add(val);
        return true;

    }

    public boolean remove(int val) {
       if(!set.contains(val)){
           return false;
       }
       set.remove(val);
       //交换当前和最后一个元素，然后移除最后一个元素
        int index = 0;
        for(int i =0; i<list.size(); i++){
            if(val == list.get(i)){
                index = i;
                break;
            }
        }

        int lastVal = list.getLast();
        list.set(index, lastVal);
        list.removeLast();

       return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

}
