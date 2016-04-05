/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponswarriors;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;


public class Warrior implements WarriorI{
    WeaponI wpn;
    String name;
    int health;
    int maxHealth;
    
    public Warrior(){
        name = "Citizen";
        health = 5;
        maxHealth = 5;
        setWeapon(new Weapon());
    }
    @Override
    public WeaponI getWeapon() {
        return wpn;
    }

    @Override
    public void setWeapon(WeaponI w) {
        wpn = w;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDefeated() {
        if(health <= 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isHealthy() {
        if(health == maxHealth){
            return true;
        }
        return false;
    }

    @Override
    public int takeDamage(WeaponI w) {
        int damage = w.getDamage();
        health -= damage;
        return damage;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
    }
    
    @Override
    public String toString(){
        System.out.println(String.format("Warrior %s, health=%d, max health=%d",name, health, maxHealth));
        return String.format("Warrior %s, health=%d, max health=%d",name, health, maxHealth);
    }
    @Override
    public void initFromString(String input) {
        Scanner s = new Scanner(input);
        s.useDelimiter("\n");
        String pat = "Warrior\\s*(\\w+),\\s*health=(\\d+),\\s*max\\s*health=(\\d+)";
        
        while(s.hasNext(pat)){
            s.next(pat);
            MatchResult m = s.match();
            String op = m.group(1);
            name = op;
            int h =  Integer.parseInt(m.group(2));
            int mh = Integer.parseInt(m.group(3));
            health = h;
            maxHealth = mh;
        }
        
    }

    @Override
    public void heal() {
        int heal = maxHealth - health;
        health += heal;
    }
    
}
