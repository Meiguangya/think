package chapter10.part1;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence1 {
    private Object[] item;
    private int next = 0;

    private Sequence1(int size) {
        item = new Object[size];
    }

    //添加对象
    public void add(Object o) {
        if (next < item.length) {
            item[next++] = o;
        }
    }


    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == item.length;
        }

        @Override
        public Object current() {
            return item[i];
        }

        @Override
        public void next() {
            if (i < item.length) {
                i++;
            }
        }

        public Sequence1 getSequence(){
            return new Sequence1(10);
        }
    }

    public Selector getSelector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {

        Sequence1 sequence1 = new Sequence1(10);

        for (int i = 0; i < sequence1.item.length; i++) {
            sequence1.add(Integer.toString(i));
        }

        Selector selector = sequence1.getSelector();

        while(!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }


    }


}
