/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponswarriors;

public interface WeaponI { 

  /**
   * Return a random amount of
   * damage. The value of the
   * damage should be at least
   * one, and no more than
   * getMaxDamage().
   */
  public int getDamage();

  /**
   * The most damage that the
   * weapon can do.
   */
  public int getMaxDamage();

  /**
   * The format should look like this:
   *
   * "Weapon {name}, damage={number}
   *
   * Note that the curly brackets are not to be taken literally. A
   * valid weaopn might be:
   * Weapon sword, damage=10
   */
  public String toString();

  /**
   * This method should take a string in the same format
   * as the toString method above, and set the name, id, and
   * damage numbers. Note that spaces may vary in length. The
   * following is valid.
   * Weapon Axe,id=2,   damage=5
   */
  public void initFromString(String input);
        
  /**
   * The name of the weapon,
   * e.g. sword, dagger, etc.
   */
  public String getName();
}
