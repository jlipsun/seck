package com.pcwerk.seck;

import java.io.File;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
    	
    	if (args.length < 1) {
    		System.out.println("usage: App <path> <search word>");
    	}

    	String path = args[0];
    	String needle = args[1];

        ArrayList<File> fileList = new ArrayList<File>();

    	Filewalker fileWalker = new Filewalker();
        fileWalker.walk(path, fileList);
        
        FileSearch search = new FileSearch();
        
        for (File haystack : fileList) {
        	int count = search.count(needle, haystack);
        	if (count > 0)
        		System.out.printf("%5d '%s' %s\n", count, needle, haystack.getAbsoluteFile());
        }
    }
}
