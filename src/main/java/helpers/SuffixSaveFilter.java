/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author oscar_sgc
 */
public class SuffixSaveFilter extends FileFilter {

    private final String suffix;

    public SuffixSaveFilter(String suffix) {

        this.suffix = suffix;
    }

    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }

        String s = f.getName();

        return s.endsWith("." + suffix) || s.endsWith("." + suffix.toUpperCase());
    }

    @Override
    public String getDescription() {

        return "*." + suffix + ",*." + suffix.toUpperCase();
    }
}
