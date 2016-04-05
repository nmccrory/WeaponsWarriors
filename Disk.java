
package weaponswarriors;

import java.io.*;
import java.util.Scanner;
import java.util.regex.MatchResult;



public class Disk implements DiskI {

    @Override
    public WarriorI loadWarrior(File f) throws IOException {
        try(FileReader fr = new FileReader(f)) {
            Scanner sr = new Scanner(fr);
            sr.useDelimiter("\n"); // delimit by line
            String pat = "Warrior\\s*(\\w+),\\s*health=(\\d+),\\s*max\\s*health=(\\d+)";
            Warrior w = new Warrior();
            while(sr.hasNext(pat)){
                sr.next(pat);
                MatchResult m = sr.match();
                String op = m.group(1);
                w.name = op;
                int h =  Integer.parseInt(m.group(2));
                int mh = Integer.parseInt(m.group(3));
                w.health = h;
                w.maxHealth = mh;
            }
            return w;
        }
    }

    @Override
    public File saveWarrior(WarriorI w) throws IOException {
        File file = new File(w.getName() + ".txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(String.format("Warrior %s, health=%d, max health=%d", w.getName(), w.getHealth(), w.getMaxHealth()));
        pw.close();
        return file;
    }

}
