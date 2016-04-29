/**
 * Created by anthony.romaniello on 4/29/16.
 */

public class YahtzeeSortDice {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    /* constructor: initializes the private data by sorting the order of the dice */
    public YahtzeeSortDice(int a, int b, int c, int d, int e) {
        int num;
        if (b < a) {
            num = b;
            b = a;
            a = num;
        }

        if (c < a) {
            num = c;
            c = b;
            b = a;
            a = num;
        } else if (c < b) {
            num = c;
            c = b;
            b = num;
        }

        if (d < a) {
            num = d;
            d = c;
            c = b;
            b = a;
            a = num;
        } else if (d < b) {
            num = d;
            d = c;
            c = b;
            b = num;
        } else if (d < c) {
            num = d;
            d = c;
            c = num;
        }

        if (e < a) {
            num = e;
            e = d;
            d = c;
            c = b;
            b = a;
            a = num;
        }

        if (e < b) {
            num = e;
            e = d;
            d = c;
            c = b;
            b = num;
        }

        if (e < c) {
            num = e;
            e = d;
            d = c;
            c = num;
        }

        if (e < d) {
            num = e;
            e = d;
            d = num;
        }

        this.first = a;
        this.second = b;
        this.third = c;
        this.fourth = d;
        this.fifth = e;
    }

    /* returns the smallest of the five numbers */
    public int getFirst() {
        return this.first;
    }

    /* returns the second smallest of the five number */
    public int getSecond() {
        return this.second;
    }

    /* returns the middle of the five numbers */
    public int getThird() {
        return this.third;
    }

    /* returns the second largest of the five numbers */
    public int getFourth() {
        return this.fourth;
    }

    /* returns the largest of the five numbers */
    public int getFifth() {
        return this.fifth;
    }
}
/* (c) Daubenmier/Ehrenfried all rights reserved */
