/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author tata
 */
public class QueryBuilder {

    Matcher match;

    public QueryBuilder() {
        match = new All();
    }

    public Matcher build() {
        try {
            return match;
        } finally {
            match = new All();
        }
    }

    public QueryBuilder playsIn(String teamName) {
        this.match = new And(match, new PlaysIn(teamName));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.match = new And(match, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.match = new And(match, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.match = new Or(matchers);
        return this;
    }
}
