/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.coders4africa.elimu.domain.school.enums;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author MSOMDA
 */
public enum GradeGroups {
    
    ELEMENTATY {
        Set<Grade> classesLevels = new LinkedHashSet<Grade>();
        public boolean contains(Grade classLevel){
           return GradeGroups.contains(classesLevels, classLevel);
        }
    },
    
    PRIMARY {
        Set<Grade> classesLevels = new LinkedHashSet<Grade>();
        public boolean contains(Grade classLevel){
           return GradeGroups.contains(classesLevels, classLevel);
        }
    },

    SECCONDARY {
        Set<Grade> classesLevels = new LinkedHashSet<Grade>();
        public boolean contains(Grade classLevel){
           return GradeGroups.contains(classesLevels, classLevel);
        }
    };
    
    public static boolean contains(Set<Grade> classes,Grade classLevel){
        return classes.contains(classLevel);
    }
    public abstract boolean contains(Grade classLevel);
}
