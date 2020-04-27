package collectaions;

import com.sun.deploy.util.SyncFileAccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        Iterator<Pet> it = pets.iterator();
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
        // A simpler approach, when possible:
        for(Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for(int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
    }



class Pet{
    int id;
    int id(){
        return id;
    }
    Pet(Integer i){
        id = i;
    }

}

class Pets{
    public static List<Pet> list(int i){
        int num=0;
        List list = new ArrayList();

        while(num<i){
            list.add(new Pet((int)Math.random()*100));
            num++;
        }
        return list;
    }

}