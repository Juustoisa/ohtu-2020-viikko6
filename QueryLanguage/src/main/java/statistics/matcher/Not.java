/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author tata
 */
public class Not implements Matcher{
    
    private Matcher match;
    
    public Not(Matcher matcher){
        this.match = matcher;
    }

    public boolean matches(Player p) {
        return !(match.matches(p));
    }
}
