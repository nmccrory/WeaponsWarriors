
package weaponswarriors;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;
public class Weapon implements WeaponI{

    
    public String name;
    int damage;
    int id;
    public int maxDamage;
    
    public Weapon(){
        name = "Stick";
        damage = 3;
        maxDamage = 6;
    }
    
    @Override
    public int getDamage() {
        Random rand = new Random();
        int damage = rand.nextInt(getMaxDamage())+1;
        return damage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }
    
    @Override
    public String toString(){
        return String.format("Weapon %s, damage=%d", getName(),getMaxDamage());
    }
    
    @Override
    public void initFromString(String input) {
        Scanner s = new Scanner(input);
        s.useDelimiter("\n");
        String pat = "Weapon\\s*(\\w+),\\s*damage=(\\d+)";
        System.out.println(s.hasNext(pat));
        while(s.hasNext(pat)){
            s.next(pat);
            MatchResult m = s.match();
            String op = m.group(1);
            name = op;
            int d =  Integer.parseInt(m.group(2));
            damage = d;
            maxDamage = d;
        }
        
        
    }

    @Override
    public String getName() {
        return name;
    }
    
}
