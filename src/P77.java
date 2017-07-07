/**
 * Created by lichao on 04/06/2017.
 * 报数退出问题
 */
public class P77 implements IAlgorithm{
    @Override
    public void exe() {
        int numOfPeople = 12;
        int numOfOut = 6;
        int a[] = new int[100];
        int out = 0;
        int nextPerson = -1;
        int nextNum = 0;
        while (out != numOfPeople - 1) {
            nextNum ++;
            nextPerson = (nextPerson + 1) % numOfPeople;
            while (a[nextPerson] != 0) {
                nextPerson = (nextPerson + 1) % numOfPeople;
            }
            if (nextNum == numOfOut) {
                a[nextPerson] = 1;
                nextNum = 0;
                out ++;
            }
        }
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println(a[i]);
        }
    }
}
