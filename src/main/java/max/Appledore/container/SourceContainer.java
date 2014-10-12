/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.container;

import java.util.ArrayList;
import max.Appledore.domain.Source;

/**
 *
 * @author FunkyO
 */
public class SourceContainer {

    ArrayList<Source> sources;

    public SourceContainer() {
        this.sources = new ArrayList();
    }

    public ArrayList<Source> getSources() {

        return this.sources;
    }

    public void addSource(Source source) {
        this.sources.add(source);
    }

}
