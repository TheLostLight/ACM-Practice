import java.util.*;

public class Tester
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> store;

        list.add("1");
        list.add("3");
        list.add("hello");

        for(int i=0; i<list.size(); i++) list.set(i, "!"+list.get(i));

        store = new ArrayList<String>(list);
        list.clear();

        for(String s : list) System.out.println("List: " + s);
        for(String s : store) System.out.println("Store: " + s);
        System.out.println("List size: " + list.size());
        System.out.println("Store size: " + store.size());
    }
}
