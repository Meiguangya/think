package chapter8.part3;


class Share {
    private int refcount = 0;
    private static long count = 0;
    private final long id = count++;

    public Share() {
        System.out.print("Creating Share" + this);
    }

    public void addref() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing" + this);
    }

    @Override
    public String toString() {
        return "Shared: " + id;
    }
}

class Composing {
    private Share share;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Share share) {
        System.out.println("Creating Composing..");
        this.share = share;
        this.share.addref();
    }

    protected void dispose() {
        System.out.println("disposing" + this);
        this.share.dispose();
    }

    @Override
    public String toString() {
        return "Composing: " + id;
    }
}

public class ReferenceCounting {

    public static void main(String[] args) {
        System.out.println("begin");
        Share share = new Share();
        Composing[] composings = {
                new Composing(share),
                new Composing(share),
                new Composing(share),
                new Composing(share),
                new Composing(share)
        };

        for (Composing c : composings) {
            c.dispose();
        }

    }

}
